package com.zjl.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zjl.order.utils.JsonUtil;
import com.zjl.product.client.output.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCPK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        List<ProductInfoOutput> productInfoOutputs = (List<ProductInfoOutput>) JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {
                    
                });
        log.info("从{}中接收到消息：{}","productInfo",productInfoOutputs);

        for (ProductInfoOutput productInfoOutput:productInfoOutputs) {
            // 存储到redis
            redisTemplate.opsForValue().set(String.format(PRODUCT_STOCPK_TEMPLATE, productInfoOutput.getProductId()),String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
