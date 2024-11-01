package com.recruitproject.controller.admin;


import com.recruitproject.config.RedisConfig;
import com.recruitproject.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin/status")
public class statusController {
      @Autowired
      private RedisTemplate redisTemplate;
      @PutMapping("/{status}")
      /**
       * 设置系统状态
       * @param status 状态 1开启 0关闭
       */
      public Result systemStatus(@PathVariable String status) {
          log.info("设置简历开放状态为:{}",status);
          redisTemplate.opsForValue().set("System_status", status);
          log.info("设置成功:当前状态为:{}",redisTemplate.opsForValue().get("System_status"));
          return Result.success("设置成功");
      }

      /**
       * 获取系统状态
       * @return 状态 1开启 0关闭
       */
      @GetMapping()
      public Result getSystemStatus() {
          String status = redisTemplate.opsForValue().get("System_status").toString();
          log.info("获取简历开放状态为：{}" ,status.equals("1") ? "开启" : "关闭");
          return Result.success(status);
      }

  }

