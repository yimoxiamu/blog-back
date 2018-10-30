package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.service.LoginService;
import com.yimoxiamu.blogback.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserControl {

    private static final Logger log = LoggerFactory.getLogger(UserControl.class);

    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/doRegist")
    public Result<String> doRegist(User user){
        log.info("==================注册逻辑开始，前段传递过来的参数为：[{}]====================",user.toString());
        return loginService.doRegist(user);
    }

    @PostMapping(value = "/doLogin")
    public Result<Map<String,String>> doLogin(User user){
        log.info("==================登录逻辑开始，前段传递过来的参数为：[{}]====================",user.toString());
        return loginService.doLogin(user);
    }

    @RequestMapping(value = "/sendEmail")
    public Result<String> sendEmail(String email){
        log.info("===================发送邮件开始，前端传递过来的参数为:[{}]===================",email);
        return loginService.sendEmail(email);
    }
}
