package com.recruitproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    public Integer code;
    public String message;
    public T data;


    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.code = 1;
        result.message = "success";
        result.data = null;
        return result;
    }
    public static <T> Result<T> success(T Object){
        Result<T> result = new Result<>();
        result.code = 1;
        result.message = "success";
        result.data = Object;
        return result;
    }
    public static <T> Result<T> error(String message){
        Result<T> result = new Result<>();
        result.code = 0;
        result.message = "message";
        return result;
    }
}
