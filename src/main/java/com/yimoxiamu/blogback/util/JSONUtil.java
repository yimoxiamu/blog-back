package com.yimoxiamu.blogback.util;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName JSONUtil
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/10/23 14:50
 * @VERSION 1.0
 **/
public class JSONUtil {

    /**
     * 对象转json字符串
     * @param object
     * @return
     */
    public static String bean2JsonString(Object object){
        if(object != null){
            return JSON.toJSONString(object);
        }else{
            return null;
        }
    }
}
