package com.bookmanger.springbootbookmanager.config;

import com.bookmanger.springbootbookmanager.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 原有的拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/books/**").excludePathPatterns("/api/user/**");
    }

    // 新增：全局跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有接口跨域
                .allowedOriginPatterns("*") // 允许所有来源（前端地址）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头（比如 token）
                .allowCredentials(true) // 允许携带 Cookie/Token
                .maxAge(3600); // 预检请求缓存时间（秒）
    }
}