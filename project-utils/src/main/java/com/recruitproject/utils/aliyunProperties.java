package com.recruitproject.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ali.oss")
public class aliyunProperties {
    public String endpoint;
    public String bucketName;

}
