
package com.miaosha.example.controller;

import java.util.List;
import java.util.UUID;

import com.miaosha.example.limit.RedisLimit;
import com.miaosha.example.pojo.MaoyanShow;
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
    public List<MaoyanShow> home() {
      boolean limit = redislimit.limit();
      if(limit){
        try {
          System.out.println("没有发生限流！");
          List<MaoyanShow> result =  testService.Test("");
          //template.convertAndSend("springbootQu","1111");
          return result;
        }
        catch (Exception ex){
          ex.printStackTrace();
        }
      }
      System.out.println("发生限流！");
		  return null;
	}

}