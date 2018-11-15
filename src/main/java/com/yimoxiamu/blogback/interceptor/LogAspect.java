package com.yimoxiamu.blogback.interceptor;

import com.yimoxiamu.blogback.tools.SysLog;
import com.yimoxiamu.blogback.util.JsonConvertUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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

    private static  final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    private void cut() { }

    @Around("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("进来了哟");
        //取得请求方法的参数
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        SysLog sysLog = method.getAnnotation(SysLog.class);
        log.info(sysLog.value());
        Object result = joinPoint.proceed();
        String ret = JsonConvertUtil.toFastJsonString(result);
        log.info(ret);
        return result;
    }



    @Before("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public void record(JoinPoint joinPoint){

    }

    @After("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
    public void after(JoinPoint joinPoint) {
    }
}
