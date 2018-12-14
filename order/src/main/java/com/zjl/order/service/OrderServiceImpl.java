package com.zjl.order.service;

import com.zjl.order.dto.OrderDto;
import com.zjl.order.entity.OrderMaster;
import com.zjl.order.repository.OrderDetailRepository;
import com.zjl.order.repository.OrderMasterRepository;
import com.zjl.order.service.Impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private OrderMasterRepository masterRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        // TODO 查询商品信息（商品服务）
        // TODO 计算总价
        // TODO 扣库存

        // 订单入库

        return null;
    }
}
