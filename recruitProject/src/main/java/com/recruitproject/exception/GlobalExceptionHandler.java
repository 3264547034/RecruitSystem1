package com.recruitproject.exception;

import com.recruitproject.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionHander(Exception ex){
        ex.printStackTrace(); //打印错误的堆栈信息
        return Result.error("操作失败，服务端出现错误");
    }
}
