package com.miaosha.example.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitConfig {

    @Bean
    public DirectExchange  messageDirectExchange (){
        return (DirectExchange) ExchangeBuilder.directExchange("springbootEx").durable(true).build();
    }
    @Bean
    public Queue messageQueue(){
        return  QueueBuilder.durable("springbootQu").build();
    }
    @Bean
    public Binding messageBinding(){
        return BindingBuilder.bind(messageQueue()).to(messageDirectExchange()).with("springbootKey");
    }

}
