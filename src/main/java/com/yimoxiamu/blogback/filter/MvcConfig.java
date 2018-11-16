package com.yimoxiamu.blogback.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(MvcConfig.class);

    @Value("${web.un.need,inter.url}")
    private String unNeedInterUrl;

    private final MyIntercept myIntercept;

    @Autowired
    public MvcConfig(MyIntercept myIntercept) {
        this.myIntercept = myIntercept;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("================不需要进拦截器的路径为：[{}]=================",unNeedInterUrl);
        registry.addInterceptor(myIntercept).addPathPatterns("/**").excludePathPatterns(unNeedInterUrl.split(","));
    }
}
