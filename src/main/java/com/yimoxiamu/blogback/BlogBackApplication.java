package com.yimoxiamu.blogback;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * @author xiamu
 */
@MapperScan(value = "com.yimoxiamu.blogback.dao")
@SpringBootApplication
public class BlogBackApplication{

    public static void main(String[] args) {
        SpringApplication.run(BlogBackApplication.class, args);
    }


    @Bean
    public FastJsonHttpMessageConverter jsonMessageConverter() {
        /*
         * 1、需要先定义一个 convert 转换消息对象；
         * 2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
         * 3、在 Convert 中添加配置信息;
         * 4、将 convert 添加到 converts 中;
         */
        //1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteBigDecimalAsPlain,
                SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        //3、在 Convert 中添加配置信息;
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        return fastConverter;
    }


    /**
     * 增加Filter
     * @return
     */
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

}
