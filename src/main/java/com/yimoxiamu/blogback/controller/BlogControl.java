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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/blogList/{pageNum}/{pageSize}")
    public Result<PageBean> blogList(@PathVariable int pageNum,@PathVariable int pageSize){
        return blogService.getBlogList(pageNum,pageSize);
    }

    @PostMapping(value = "/addLike")
    public Result<String> blogLike(String uuid , int likeCount){
        return blogService.addLike(uuid,likeCount);
    }

}
