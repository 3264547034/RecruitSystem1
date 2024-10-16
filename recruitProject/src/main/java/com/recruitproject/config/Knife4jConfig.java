package com.recruitproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                // 配置接口文档基本信息
                .info(this.getApiInfo())
                ;
    }

    private Info getApiInfo() {
        return new Info()
                // 配置文档标题
                .title("招聘管理系统")
                // 配置文档描述
                .description("招聘管理系统接口文档")
                // 配置作者信息
                .contact(new Contact().name("Melody").url("https://www.xiezhrspace.cn").email("1666397814@163.com"))
                // 配置License许可证信息
                .license(new License().name("Apache 2.0").url("https://www.xiezhrspace.cn"))
                // 概述信息
                .summary("招聘管理系统概述信息")
                .termsOfService("https://www.xiezhrspace.cn")
                // 配置版本号
                .version("2.0");
    }
}

