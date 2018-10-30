//package com.yimoxiamu.blogback.interceptor;
//
//import com.yimoxiamu.blogback.util.RequestContextHolderUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName LogAspect
// * @Description TODO
// * @Author paw
// * @Email 768840822@qq.com
// * @Date 2018/10/24 10:00
// * @VERSION 1.0
// **/
//@Component
//@Aspect
//public class LogAspect {
//
//
//    @Pointcut("@annotation(com.yimoxiamu.blogback.tools.SysLog)")
//    private void cut() { }
//
//    @Around("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
//    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
//        Map<String,Object> logMap=new HashMap<>();
//        Object result=null;
//        //取得请求方法的参数
//        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//
//        HttpServletRequest request = RequestContextHolderUtils.getServletRequest();
//
//        //获取请求体
//        Object requestBody = AnnotationResolver.newInstance().resolverArgsWithAnnotation(joinPoint, RequestBody.class);
//
//        if(requestBody == null) {
//            requestBody = getParamObjectMap(request);
//        }
//        String jsonStr = "";
//        if(requestBody != null && JsonConvertUtil.IsJsonString(requestBody)) {
//            jsonStr = requestBody.toString();
//        } else {
//            jsonStr = JsonConvertUtil.toFastJsonString(requestBody);
//        }
//
//        SysLog sysLog = method.getAnnotation(SysLog.class);
//
//        //获取用户ID
//        String userid = TokenUtil.getUserId();
//        String requestPath=null;//请求URL
//        if(StringUtil.isNotEmpty(request)){
//            requestPath=request.getServletPath();
//        }
//        logMap.put("user_id",userid);
//        logMap.put("log_url",requestPath);
//        logMap.put("log_content",jsonStr);
//        //获得返回体
//        result = joinPoint.proceed();
//        String retStr = JsonConvertUtil.toFastJsonString(result);
//
//        logMap.put("return_content",retStr);
//        logMap.put("log_type",sysLog.value());
//
//        try{
//            logService.addLog(logMap);
//        }catch (Exception e) {
//            logger.error("error:", e);
//        }
//
//        return result;
//
//    }
//
//
//
//    @Before("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
//    public void record(JoinPoint joinPoint){
//
//    }
//
//    @After("cut()&&@annotation(com.yimoxiamu.blogback.tools.SysLog)")
//    public void after(JoinPoint joinPoint) {
//    }
//}
