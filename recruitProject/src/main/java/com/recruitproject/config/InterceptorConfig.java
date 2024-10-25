package com.recruitproject.config;


import com.recruitproject.Interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override   // 配置拦截器白名单
    public void addInterceptors(InterceptorRegistry registry) {
        // 对knife4j的请求不进行拦截
        String[] excludePatterns = new String[]{"/swagger-resources/**", "/webjars/**", "/v3/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**", "/doc.html/**","/login/**","/upload/**"};

        registry.addInterceptor(loginCheckInterceptor)
                // 拦截所有请求
                .addPathPatterns("/**")
                .excludePathPatterns(excludePatterns);
    }
}
