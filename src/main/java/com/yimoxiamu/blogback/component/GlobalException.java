package com.yimoxiamu.blogback.component;

import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

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

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(value = Exception.class)
    public Result<T> catchGlobalException(Exception e){
        log.error("发生异常,异常类型为："+e.getMessage());
        e.printStackTrace();
        if(e instanceof CustomGolbalException){
            return Result.error(((CustomGolbalException) e).getCodeMsg());
        }else if(e instanceof SQLException){
            return Result.error(CodeMsg.DATA_ERROR);
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
