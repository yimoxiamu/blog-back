package com.yimoxiamu.blogback.constant;

/**
 * @ClassName CodeMsg
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 14:12
 * @VERSION 1.0
 **/
public class CodeMsg {
    private int code;
    private String message;

    public static CodeMsg SERVER_ERROR=new CodeMsg(10010,"服务器异常");

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

    public CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
