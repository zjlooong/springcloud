package com.zjl.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    @Input("myMessage1")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();
}
