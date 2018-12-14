package com.zjl.order.service.Impl;

import com.zjl.order.dto.OrderDto;

public interface OrderService {

    /**
     * 创建订单
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);
}
