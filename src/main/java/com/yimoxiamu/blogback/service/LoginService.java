package com.yimoxiamu.blogback.service;

import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.tools.Result;

public interface LoginService {

    /**
     *注册逻辑
     * @param user
     * @return
     */
    public Result<String> doRegist(User user);
}
