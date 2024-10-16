package com.recruitproject.Interceptor;

import ch.qos.logback.core.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.recruitproject.pojo.Result;
import com.recruitproject.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtils JwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //获取请求的url
        String url = request.getRequestURI();
        log.info("请求的url："+url);

        String Jwt = request.getHeader("Authorization");
        log.info("请求的令牌："+Jwt);
        if(!StringUtils.hasLength(Jwt)){
            log.info("请求头的令牌为空，未登录");
            Result error = Result.error("NOT_LOGIN");
            //转化为json格式
            String NotLogin = JSONObject.toJSONString(error);
            response.getWriter().write(NotLogin);
            return false;
        }

        try {
            JwtUtils.parseJwt(Jwt);
        }catch (Exception e){
            log.info("令牌解析错误,返回错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        log.info("令牌正确，放行");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav){
        System.out.println("postHandle.....");
    }
}
