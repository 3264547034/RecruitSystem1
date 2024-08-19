package com.recruitproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class timeTest {
    @Around("execution(* com.recruitproject.server.*.*(..))")
    public Object timeTest(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {

        long begin  = System.currentTimeMillis();
        Object result =  proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"执行耗时: {}ms",end-begin);
        return result;
    }


}