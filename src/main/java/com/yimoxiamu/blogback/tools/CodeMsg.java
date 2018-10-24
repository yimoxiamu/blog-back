package com.yimoxiamu.blogback.tools;

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

    //通用异常类型
    public static CodeMsg SERVER_ERROR=new CodeMsg(10010,"服务器异常");
    public static CodeMsg TOKEN_ERROR=new CodeMsg(10011,"token非法");
    //文章阅读，点赞人数
    public static CodeMsg ADD_LIKE_ERROR=new CodeMsg(20010,"增加点赞人数发生错误");
    public static CodeMsg ADD_READ_ERROR=new CodeMsg(20011,"增加阅读人数发生错误");
    //登录注册
    public static CodeMsg REGIST_ERROR=new CodeMsg(30010,"注册账号发生错误");
    //发表文章异常
    public static CodeMsg PULL_BLOG_ERROR=new CodeMsg(20011,"增加阅读人数发生错误");


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
