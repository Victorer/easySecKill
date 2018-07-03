package com.miaosha.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {
    @RabbitListener(queues="springbootQu")
    public void processC(String str) {
        System.out.println("Receive:"+str);
    }

}
