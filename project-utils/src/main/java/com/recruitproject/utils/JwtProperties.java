package com.recruitproject.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "recruitproject.jwt")
public class JwtProperties {
    public String adminSecretKey = "recruit";
    public Long adminTtl = 600000000L;

}
