package com.recruitproject;


import com.recruitproject.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Test
    void RedisTest() {
        String status = "abcsad";
        redisTemplate.opsForValue().set("name", status);
       String value = redisTemplate.opsForValue().get("a");
       System.out.println(value);
    }
}
