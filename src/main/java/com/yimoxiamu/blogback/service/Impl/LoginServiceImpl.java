package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.dao.UserMapper;
import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.service.LoginService;
import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public Result<String> doRegist(User user) {

        int i = userMapper.insertSelective(user);
        if (i == 1){
            return Result.success("注册成功！");
        }
        return Result.error(CodeMsg.REGIST_ERROR);
    }
}
