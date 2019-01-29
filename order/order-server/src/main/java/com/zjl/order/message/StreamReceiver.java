package com.zjl.order.message;

import com.zjl.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener("myMessage")
//    public void process(Object message){
//        log.info("StreamReveiver: {}",message);
//    }

    @StreamListener("myMessage")
    public void process(OrderDto message){
        log.info("StreamReveiver: {}",message);
    }

}
