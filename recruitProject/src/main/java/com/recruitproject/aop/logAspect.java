package com.recruitproject.aop;

import com.alibaba.fastjson.JSONObject;
import com.recruitproject.pojo.LogInfo;
import com.recruitproject.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.recruitproject.server.opLogServer;
import org.springframework.validation.ObjectError;

import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class logAspect {
    //记录service层的日志操作
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private opLogServer opLogServer;

    @Around("@annotation(com.recruitproject.anno.Log)")
    public Object serverLog(ProceedingJoinPoint joinPoint) throws Throwable{
       //解析jwt令牌
       String jwt = request.getHeader("Authorization");
       Claims claims = JwtUtils.parseJwt(jwt);
       //获取id
       String uid =  (String) claims.get("id");
       //获取操作时间
        LocalDate data = LocalDate.now();
        //获取方法名称
        String opName = joinPoint.getSignature().getName();
        //获取类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取构造函数参数
        Object[] args = joinPoint.getArgs();
        String arg = Arrays.toString(args);
//        String arg = null;
        //起始执行时间
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long time = end - begin;
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);
        LogInfo logInfo = new LogInfo(uid,opName,className,arg,time,data,returnValue);
        //插入日志表
        opLogServer.insertLog(logInfo);

        return result;
    }


}
