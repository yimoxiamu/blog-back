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
}
