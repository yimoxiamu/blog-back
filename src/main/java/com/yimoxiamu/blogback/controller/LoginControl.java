package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.service.LoginService;
import com.yimoxiamu.blogback.tools.Result;
import factory.Log;
import factory.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginControl {

    private static final Log log= LogFactory.getLog(LoginControl.class);

    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/doRegist")
    public Result<String> doRegist(User user){
        log.info("注册逻辑开始，前段传递过来的参数为：[{}]",user.toString());
        return loginService.doRegist(user);
    }
}
