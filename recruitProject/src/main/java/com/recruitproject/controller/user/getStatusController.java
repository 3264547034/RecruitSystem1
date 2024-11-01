package com.recruitproject.controller.user;

import com.recruitproject.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/status")
public class getStatusController {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取系统状态
     * @return
     */
    @GetMapping()
    public Result getStatus() {
        log.info("获取系统状态:{}",redisTemplate.opsForValue().get("System_status"));
        return Result.success(redisTemplate.opsForValue().get("System_status"));
    }
}
