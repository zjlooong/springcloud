package com.zjl.order.converter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjl.order.dto.OrderDto;
import com.zjl.order.entity.OrderDetail;
import com.zjl.order.enums.ExceptionCode;
import com.zjl.order.exception.OrderException;
import com.zjl.order.request.OrderRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRequestOrderDTOConvert {

    public static OrderDto convert(OrderRequest request){
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(request.getName());
        orderDto.setBuyerAddress(request.getAddress());
        orderDto.setBuyerPhone(request.getPhone());
        orderDto.setBuyerOpenid(request.getOpenid());

        List<OrderDetail> orderDetails = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            orderDetails = mapper.readValue(request.getItems(),new TypeReference<List<OrderDetail>>() { });
        } catch (IOException e) {
            throw new OrderException(ExceptionCode.PARAM_ERROR);
        }
        orderDto.setOrderDetails(orderDetails);
        return orderDto;
    }
}
