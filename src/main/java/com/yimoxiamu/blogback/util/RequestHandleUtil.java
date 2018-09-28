package com.yimoxiamu.blogback.util;

import com.yimoxiamu.blogback.component.CustomGolbalException;
import com.yimoxiamu.blogback.tools.CodeMsg;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestHandleUtil
 * @Description Request相关工具类
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 10:39
 * @VERSION 1.0
 **/
public class RequestHandleUtil {

    private static final String TOKEN_KEY="Authorization";


    /**
     * 通用请求token获取方法
     * @return token
     */
    private String getToken(){
        String token = null;
        HttpServletRequest request = getRequest();
        if(request != null){
            token=request.getHeader(TOKEN_KEY);
        }
        return token;
    }


    /**
     * 获取本次请求的request
     * @return request
     */
    private HttpServletRequest getRequest(){
        HttpServletRequest request=null;
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                request = ((ServletRequestAttributes)requestAttributes).getRequest();
            }
        }catch (Exception e){
            throw new CustomGolbalException(CodeMsg.SERVER_ERROR);
        }
        return request;
    }
}
