package com.yimoxiamu.blogback.controller;

import com.github.pagehelper.PageInfo;
import com.yimoxiamu.blogback.dao.BlogMainMapper;
import com.yimoxiamu.blogback.entity.BlogMain;
import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import factory.Log;
import factory.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BlogControl
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 13:45
 * @VERSION 1.0
 **/
@RestController
@RequestMapping(value = "/blog")
public class BlogControl {

    private static final Log log = LogFactory.getLog(BlogControl.class);

    @Autowired
    private BlogService blogService;
    @Autowired(required = false)
    private BlogMainMapper blogMainMapper;

    @GetMapping(value = "/blogList")
    public Result<PageBean> blogList(){
        return blogService.blogList(1,3);
    }

    @GetMapping(value = "test")
    public String test(){
        BlogMain blogMain = blogMainMapper.selectByPrimaryKey(1);
        log.info(blogMain);
        return "ok";
    }

}
