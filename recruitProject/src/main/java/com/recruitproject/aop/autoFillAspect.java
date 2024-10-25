package com.recruitproject.aop;

import com.recruitproject.anno.AutoFill;
import com.recruitproject.enumeration.operationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class autoFillAspect {

    /**
     * 切入点
     */
    @Pointcut("execution(* com.recruitproject.mapper.*.*(..))&&@annotation(com.recruitproject.anno.AutoFill)")
    public void autoFillPointcut() {}
    /**
     * 前置通知对方法进行拦截来自动填充数据
     */
    @Before("autoFillPointcut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("autoFillAspect.autoFill() start");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); //获取方法签名
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class); //获取方法注解
       operationType operationType = autoFill.value(); //获取注解参数

        Object[] args = joinPoint.getArgs(); //获取方法参数
        if(args==null || args.length==0){
            return;
        }
        Object entity = args[0]; //获取第一个参数

        //准备赋值的数据
        LocalDateTime now = LocalDateTime.now();

        //根据不同的操作类型进行赋值
        if(operationType==operationType.insert){ //插入操作
            try {
                Method updateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method createTime = entity.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);

                //通过反射调用方法进行赋值
                updateTime.invoke(entity, now);
                createTime.invoke(entity, now);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(operationType==operationType.update){ //更新操作
            try {
                Method update_time = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);

                //通过反射调用方法进行赋值
                update_time.invoke(entity, now);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }


}
