package com.yimoxiamu.blogback;

import factory.Log;
import factory.LogFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName LogTest
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 9:26
 * @VERSION 1.0
 **/
@SpringBootTest
public class LogTest {

    private static final Log log = LogFactory.getLog(LogTest.class);

    @Test
    public void test(){
        log.error("测试日志");
        log.info("123456");
    }
}
