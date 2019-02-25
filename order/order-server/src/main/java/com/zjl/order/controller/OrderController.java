package com.zjl.order.controller;

import com.zjl.order.converter.OrderRequestOrderDTOConvert;
import com.zjl.order.dto.CartDTO;
import com.zjl.order.dto.OrderDto;
import com.zjl.order.entity.ProductInfo;
import com.zjl.order.enums.ExceptionCode;
import com.zjl.order.exception.OrderException;
import com.zjl.order.request.OrderRequest;
import com.zjl.order.service.Impl.OrderService;
import com.zjl.order.vo.InvokeResult;
import com.zjl.product.client.ProductClient;
import com.zjl.product.client.input.DecreaseStockInput;
import com.zjl.product.client.output.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductClient productClient;

    @PostMapping("create")
    public InvokeResult create(@Valid OrderRequest request, BindingResult result){
        if(result.hasErrors()){
            throw new OrderException(ExceptionCode.PARAM_ERROR.getCode(),result.getFieldError().getDefaultMessage());
        }
        OrderDto convert = OrderRequestOrderDTOConvert.convert(request);
        if(CollectionUtils.isEmpty(convert.getOrderDetails())){
            throw new OrderException(ExceptionCode.ORDER_EMPTY);
        }
        OrderDto orderDto = orderService.create(convert);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderDto.getOrderId());
        return InvokeResult.success(map);
    }

    @GetMapping("listForOrder")
    public List<ProductInfoOutput> listForOrder(){
        return productClient.listForOrder(Arrays.asList("157875196366160022","157875227953464068"));
    }

    @GetMapping("decreaseStock")
    public void decreaseStock(){
        List<DecreaseStockInput> cartDTOS = Arrays.asList(
                new DecreaseStockInput("157875196366160022", 1),
                new DecreaseStockInput("157875227953464068", 1)
        );
        productClient.decreaseStock(cartDTOS);
    }

    @PostMapping("finish")
    public InvokeResult finish(@RequestParam String orderId){
        return InvokeResult.success(orderService.finsish(orderId));
    }
}
