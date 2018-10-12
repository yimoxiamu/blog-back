package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import factory.Log;
import factory.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
@SuppressWarnings(value = "unchecked")
public class BlogControl {

    private static final Log log = LogFactory.getLog(BlogControl.class);

    private final BlogService blogService;

    @Autowired
    public BlogControl(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 获取文章列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/blogList/{pageNum}/{pageSize}")
    public Result<PageBean> blogList(@PathVariable int pageNum,@PathVariable int pageSize){
        log.info("=================获取文章列表开始===============");
        return blogService.getBlogList(pageNum,pageSize);
    }

    @GetMapping(value = "/blogInfo/{id}")
    public Result<Map<String,Object>> blogInfo(@PathVariable int id){
        log.info("==================获取文章详情开始===============");
        return blogService.getBlogInfo(id);
    }


    /**
     * 增加喜欢人数
     * @param uuid
     * @param likeCount
     * @return
     */
    @PostMapping(value = "/addLike")
    public Result<String> blogLike(String uuid , int likeCount){
        return blogService.addLike(uuid,likeCount);
    }

}
