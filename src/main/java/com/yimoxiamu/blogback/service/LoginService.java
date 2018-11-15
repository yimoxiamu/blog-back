package com.yimoxiamu.blogback.service;

import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.tools.Result;

import java.util.Map;

public interface LoginService {

    /**
     *注册逻辑
     * @param user
     * @return
     */
     Result<String> doRegist(User user);

    /**
     * 登录逻辑
     * @param user
     * @return
     */
     Result<Map<String,String>> doLogin(User user);

    /**
     * 发送邮箱验证码逻辑
     * @param email
     * @return
     */
     Result<String> sendEmail(String email);

    /**
     * 验证邮箱验证码逻辑
     * @param email
     * @return
     */
    Result<String> checkEmail(String email);
}
