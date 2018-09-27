package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.MainService;
import factory.Log;
import factory.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 11:33
 * @VERSION 1.0
 **/
@RestController
@SuppressWarnings(value = "unchecked")
public class MainController {

    private static final Log log=LogFactory.getLog(MainController.class);
    @Autowired
    private MainService mainService;

    @GetMapping("/test")
    public String test(){
        log.info("123456");
        mainService.test();
        return "ok";
    }
}
