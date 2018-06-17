
package com.miaosha.example.controller;

import java.util.UUID;

import com.miaosha.example.limit.RedisLimit;
import com.miaosha.example.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

  @Autowired 
  private RedisLimit redislimit;

  @Autowired 
  private TestService testService;

    @RequestMapping("/")
    public String home() {
      boolean limit = redislimit.limit();
      if(limit){
        System.out.println("没有发生限流！");
        testService.Test(UUID.randomUUID().toString());
        return "没有发生限流！";
      }
      System.out.println("发生限流！");
		  return "发生限流！";
	}

}