package com.yimoxiamu.blogback.component;

import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.Result;
import factory.Log;
import factory.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalException
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 14:11
 * @VERSION 1.0
 **/
@RestControllerAdvice
@SuppressWarnings(value = "unchecked")
public class GlobalException<T> {

    private static final Log log=LogFactory.getLog(GlobalException.class);

    @ExceptionHandler(value = Exception.class)
    public Result<T> catchGlobalException(Exception e){
        log.error("发生异常,异常类型为："+e.getMessage());
        e.printStackTrace();
        if(e instanceof CustomGolbalException){
            return Result.error(((CustomGolbalException) e).getCodeMsg());
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
