package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.entity.BlogMain;
import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import com.yimoxiamu.blogback.tools.SysLog;
import com.yimoxiamu.blogback.util.JSONUtil;
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
    @SysLog(value = "获取文章列表")
    @GetMapping(value = "/list/{pageNum}/{pageSize}")
    public Result<PageBean> blogList(@PathVariable int pageNum,@PathVariable int pageSize){
        log.info("=================获取文章列表开始===============");
        return blogService.getBlogList(pageNum,pageSize);
    }

    /**
     * 获取文章详情
     * @param id 文章id
     * @return @
     */
    @SysLog(value = "文章详情")
    @GetMapping(value = "/info/{id}")
    public Result<Map<String,Object>> blogInfo(@PathVariable int id){
        log.info("==================获取文章详情开始===============");
        return blogService.getBlogInfo(id);
    }


    /**
     * 增加喜欢人数
     * @param id 文章id
     * @return @
     */
    @SysLog(value = "增加喜欢人数")
    @PostMapping(value = "/addLike")
    public Result<String> blogLike(int id){
        log.info("==================增加文章喜欢人数开始===============");
        return blogService.addLike(id);
    }

    /**
     * 增加阅读人数
     * @param id
     * @return
     */
    @SysLog(value = "增加阅读人数")
    @PostMapping(value = "/addRead")
    public Result<String> blogRead(int id){
        log.info("==================增加阅读人数开始===================");
        return blogService.addRead(id);
    }

    /**
     * 发表文章
     * @param blogMain
     * @return
     */
    @SysLog(value = "发表文章")
    @PutMapping(value = "/pull")
    public Result<String> pullBlog(@RequestBody BlogMain blogMain){
        log.info("==================发表文章开始,前段传递过来的参数为:[{}]====================",JSONUtil.bean2JsonString(blogMain));
        return blogService.pullBlog(blogMain);
    }
}
