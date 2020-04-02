package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @description:
 * @create: 2020/4/2 14:30
 **/
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    @Bean("redisTemplate")
    public RedisTemplate<String, ?> padRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ?> template = new StringRedisTemplate(redisConnectionFactory);
        return template;
    }
}
