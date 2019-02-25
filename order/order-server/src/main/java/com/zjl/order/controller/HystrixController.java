package com.zjl.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * 链路熔断
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @GetMapping("getProductInfoList")
//    @HystrixCommand(
//            // 可配置到配置文件
//        commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"), //设置超时时间3s
//                // 熔断机制打开 10次内超过60%的错误则启动链路熔断窗口，计时时间10000s 之后放开尝试，若成功则关闭链路熔断，失败则重新计时
//                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         //断路器的最小请求数
//                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = " 10000"),   //休眠时间
//                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")        //断路频率
//        }
//    )
    @HystrixCommand
    public String getProductInfoList(){
        // 访问其他服务请求。。。
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:12001/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
//        throw new  RuntimeException("发生异常");
    }

    public String fallback(){
        return "网页跑丢了！";
    }
    public String defaultFallback(){
        return "哎呀，网页跑丢了！";
    }
}
