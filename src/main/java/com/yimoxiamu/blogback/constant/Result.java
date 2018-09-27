package com.yimoxiamu.blogback.constant;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName Result
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 14:12
 * @VERSION 1.0
 **/
@SuppressWarnings(value = "unchecked")
public class Result<T> {
    @JSONField(ordinal = 2)
    private T data;
    @JSONField(ordinal = 1)
    private int code;
    @JSONField(ordinal = 3)
    private String message;

    public static<T> Result<T> success(T data){
        return new Result(data,0,"success");
    }

    public static<T> Result<T> error(CodeMsg codeMsg){
        return new Result(codeMsg);
    }


    private Result(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    private Result(CodeMsg codeMsg){
        if(codeMsg != null){
            this.code=codeMsg.getCode();
            this.message=codeMsg.getMessage();
        }
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
