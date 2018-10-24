package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(BlogControl.class);

    private final BlogService blogService;

    @Autowired
    public BlogControl(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 获取文章列表
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return @
     */
    @GetMapping(value = "/blogList/{pageNum}/{pageSize}")
    public Result<PageBean> blogList(@PathVariable int pageNum,@PathVariable int pageSize){
        log.info("=================获取文章列表开始===============");
        return blogService.getBlogList(pageNum,pageSize);
    }

    /**
     * 获取文章详情
     * @param id 文章id
     * @return @
     */
    @GetMapping(value = "/blogInfo/{id}")
    public Result<Map<String,Object>> blogInfo(@PathVariable int id){
        log.info("==================获取文章详情开始===============");
        return blogService.getBlogInfo(id);
    }


    /**
     * 增加喜欢人数
     * @param id 文章id
     * @return @
     */
    @PostMapping(value = "/addLike/{id}")
    public Result<String> blogLike(@PathVariable int id){
        log.info("==================增加文章喜欢人数开始===============");
        return blogService.addLike(id);
    }

}
