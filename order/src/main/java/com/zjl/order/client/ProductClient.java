package com.zjl.order.client;

import com.zjl.order.dto.CartDTO;
import com.zjl.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> products);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
