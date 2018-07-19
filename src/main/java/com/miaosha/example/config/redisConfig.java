package com.miaosha.example.config;

import com.miaosha.example.limit.RedisLimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class redisConfig {
    
    @Value("${limit}")
    private int limit;
    
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public RedisLimit build() {
        // JedisPoolConfig config = new JedisPoolConfig();
        // config.setMaxIdle(10);
        // config.setMaxTotal(300);
        // config.setMaxWaitMillis(10000);
        // config.setTestOnBorrow(true);
        // config.setTestOnReturn(true);
        // JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config);
        // jedisConnectionFactory.setHostName("47.98.194.60");
        // jedisConnectionFactory.setPort(6379);
        // jedisConnectionFactory.setPassword("");
        // jedisConnectionFactory.setTimeout(100000);
        // jedisConnectionFactory.afterPropertiesSet();
        RedisLimit redisLimit = new RedisLimit.Builder(jedisConnectionFactory, 1)
                .limit(limit)
                .build();
        return redisLimit;
    }
    

}