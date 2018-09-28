package com.yimoxiamu.blogback.component;

import com.yimoxiamu.blogback.tools.CodeMsg;

/**
 * @ClassName CustomGolbalException
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 14:52
 * @VERSION 1.0
 **/
public class CustomGolbalException extends RuntimeException {
    private static final Long serialVersionUID = 1L;
    private CodeMsg codeMsg;
    public CustomGolbalException(CodeMsg codeMsg){
        super(codeMsg.toString());
        this.codeMsg=codeMsg;
    }


    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
