package com.zjl.product.client;

import com.zjl.product.client.input.DecreaseStockInput;
import com.zjl.product.client.output.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> products);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs);

    @Component
    static class ProductClientFallback implements  ProductClient{

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> products) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputs) {

        }
    }
}
