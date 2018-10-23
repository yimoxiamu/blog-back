package com.yimoxiamu.blogback.filter;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.util.JSONUtil;
import com.yimoxiamu.blogback.util.RequestContextHolderUtils;
import com.yimoxiamu.blogback.util.StringUtils;
import com.yimoxiamu.blogback.util.TokenUtil;
import factory.Log;
import factory.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Intercept
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 10:38
 * @VERSION 1.0
 **/
@Component
@SuppressWarnings(value = "unchecked")
public class MyIntercept implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog(MyIntercept.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //跨域测试请求方法放行
        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        String token = RequestContextHolderUtils.getAuthorizationToken();
        if(StringUtils.isNotBlank(token) && TokenUtil.isValid(token)){
            return true;
        }else{
            log.info("token不存在或是已经过期");
            responseWriter(response,JSONUtil.bean2JsonString(CodeMsg.TOKEN_ERROR));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }



    public static void responseWriter(HttpServletResponse response, String jString){
        try{
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(jString);
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
