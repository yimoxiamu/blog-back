package com.yimoxiamu.blogback.interceptor;

import com.yimoxiamu.blogback.dao.LogMapper;
import com.yimoxiamu.blogback.entity.Log;
import com.yimoxiamu.blogback.tools.SysLog;
import com.yimoxiamu.blogback.util.JsonConvertUtil;
import com.yimoxiamu.blogback.util.RequestContextHolderUtils;
import com.yimoxiamu.blogback.util.StringUtils;
import com.yimoxiamu.blogback.util.TokenUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/10/24 10:00
 * @VERSION 1.0
 **/
@Component
@Aspect
public class LogAspect {

    @Autowired(required = false)
    private LogMapper logMapper;

    private static  final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    private void cut() { }

    @Around("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        Log log = new Log();
        //取得请求方法的参数
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        log.setType(sysLog.value());
        HttpServletRequest request = RequestContextHolderUtils.getServletRequest();
        log.setIp(request.getRemoteAddr());
        log.setRequest_path(request.getServletPath());
        if(!request.getServletPath().contains("img")){
            if(StringUtils.isNotBlank(TokenUtil.getUserId())) {
                log.setUser_id(Integer.valueOf(TokenUtil.getUserId()));
            }
        }
        Object result = joinPoint.proceed();
        String ret = JsonConvertUtil.toFastJsonString(result);
        log.setResponse_content(ret);
        log.setCreate_time(new Date());
        logMapper.insertSelective(log);
        return result;
    }



    @Before("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public void record(JoinPoint joinPoint){

    }

    @After("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public void after(JoinPoint joinPoint) {
    }
}
