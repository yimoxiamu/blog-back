package com.yimoxiamu.blogback.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName InterceptConfig
 * @Description 跨域支持
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 10:01
 * @VERSION 1.0
 **/
@Configuration
public class CorsConfig {

    private static final Logger log = LoggerFactory.getLogger(CorsConfig.class);

    @Value("${web.allow.url}")
    private  String WEB_ALLOW_URL;


    public  CorsConfiguration buildCors(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        log.info(WEB_ALLOW_URL);
        String [] origins = WEB_ALLOW_URL.split(",");
        for (int i = 0; i <origins.length; i++) {
            corsConfiguration.addAllowedOrigin(origins[i]);
        }
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }


    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildCors());
        CorsFilter corsFilter=new CorsFilter(source);
        return corsFilter;
    }

}
