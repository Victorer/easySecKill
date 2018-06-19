package com.miaosha.example.service.Impl;

import java.util.Collections;

import com.miaosha.example.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.connection.RedisClusterConnection;
import com.miaosha.example.util.ScriptUtil;

import redis.clients.jedis.Jedis;

@Service("TestService")
public class TestServiceImpl implements TestService {


    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;


    @Override
    public String Test(String itemId){
        Object result = null;
        Object connection = getConnection();
        result =  ((Jedis)connection).eval(ScriptUtil.getScript("SecKill.lua"),Collections.singletonList(itemId),Collections.singletonList("1"));
        if(1 == (Long)result){
           System.out.println("创建订单！");
        }
        else{
            System.out.println("商品已经卖完");
        }
        return "";
    }
    private Object getConnection() {
        Object connection ;
            RedisConnection redisConnection = jedisConnectionFactory.getConnection();
            connection = redisConnection.getNativeConnection();
        return connection;
    }

}