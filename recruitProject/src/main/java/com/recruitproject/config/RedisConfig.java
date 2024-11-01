package com.recruitproject.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisTemplateConfig
 */
@Configuration
@Slf4j
public class RedisConfig {
    @Bean
    public RedisTemplate RedisTemplate (RedisConnectionFactory connectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置key的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化方式
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());


        return redisTemplate;
    }
}
