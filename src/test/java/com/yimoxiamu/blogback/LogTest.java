package com.yimoxiamu.blogback;

import com.alibaba.fastjson.JSONObject;
import factory.Log;
import factory.LogFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

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
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("test","nan");
        jsonObject.put("age",132);
        Map<String,Object> map=new HashMap<>();
        map.put("naem","123");
        map.put("age",123);
        System.out.println(jsonObject.toJSONString());
        log.error("测试日志内容为：[{}]");
        log.info(map);
    }
}
