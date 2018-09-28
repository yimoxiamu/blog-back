package com.yimoxiamu.blogback.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MvcConfig
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 10:51
 * @VERSION 1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${web.un.need,inter.url}")
    private String unNeedInterUrl;

    @Autowired
    private MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myIntercept).addPathPatterns("/**").excludePathPatterns(unNeedInterUrl.split(","));
    }
}
