package com.zjl.order.service;

import com.zjl.order.client.ProductClient;
import com.zjl.order.dto.CartDTO;
import com.zjl.order.dto.OrderDto;
import com.zjl.order.entity.OrderDetail;
import com.zjl.order.entity.OrderMaster;
import com.zjl.order.entity.ProductInfo;
import com.zjl.order.enums.OrderStatusEnum;
import com.zjl.order.enums.PayStatusEnum;
import com.zjl.order.repository.OrderDetailRepository;
import com.zjl.order.repository.OrderMasterRepository;
import com.zjl.order.service.Impl.OrderService;
import com.zjl.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private OrderMasterRepository masterRepository;

    @Autowired
    ProductClient productClient;
    @Override
    public OrderDto create(OrderDto orderDto) {

        String orderId = KeyUtil.genUniqueKey();
        // 查询商品信息（商品服务）
        List<String> productIds = orderDto.getOrderDetails().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());

        List<ProductInfo> productInfos = productClient.listForOrder(productIds);

        // 计算总价
        BigDecimal amout = new BigDecimal(0);
        for (OrderDetail orderDetail:orderDto.getOrderDetails()) {
            for (ProductInfo productInfo:productInfos) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())){
                    amout = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(amout);

                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    detailRepository.save(orderDetail);
                }
            }
        }

        // TODO 扣库存
        List<CartDTO> cartDTOS = orderDto.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOS);
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(amout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        masterRepository.save(orderMaster);
        return orderDto;
    }
}
