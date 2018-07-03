
package com.miaosha.example.controller;

import java.util.UUID;

import com.miaosha.example.limit.RedisLimit;
import com.miaosha.example.service.TestService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

  @Autowired 
  private RedisLimit redislimit;

  @Autowired 
  private TestService testService;

  @Autowired
  private AmqpTemplate template;

  @RequestMapping("/")
    public String home() {
      boolean limit = redislimit.limit();
      if(limit){
        try {
          System.out.println("没有发生限流！");
          testService.Test(UUID.randomUUID().toString());
          template.convertAndSend("springbootQu","1111");
          return "没有发生限流！";
        }
        catch (Exception ex){
          ex.printStackTrace();
        }
      }
      System.out.println("发生限流！");
		  return "发生限流！";
	}

}