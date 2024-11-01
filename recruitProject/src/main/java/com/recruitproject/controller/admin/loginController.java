package com.recruitproject.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.recruitproject.pojo.HR;
import com.recruitproject.pojo.Result;
import com.recruitproject.pojo.jobseekerAccount;
import com.recruitproject.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.recruitproject.server.loginServer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController

public class loginController {
    @Autowired
    private loginServer loginServer;
    private JwtUtils JwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody jobseekerAccount jobseekerAccount){
        log.info("员工账号信息:{}"+jobseekerAccount);
        jobseekerAccount account = loginServer.login(jobseekerAccount);
        if(account != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",account.getUid());
            claims.put("password",account.getPassword());
            String Jwt = JwtUtils.generateJwt(claims);
            log.info("下放令牌"+Jwt);
            return Result.success(Jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/VerifyToken")
    public Result VerifyToken(@RequestBody String Jwt){
        log.info("校验令牌"+Jwt);
        try {
            JwtUtils.parseJwt(Jwt);
        }catch (Exception e){
            log.info("令牌过期");
            return Result.error("登录过期，重新登录");
        }
        log.info("令牌正确，放行");
        return Result.success();
    }


}
