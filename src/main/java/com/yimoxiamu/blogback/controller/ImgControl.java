package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.entity.BlogImg;
import com.yimoxiamu.blogback.service.BlogImgService;
import com.yimoxiamu.blogback.tools.Result;
import com.yimoxiamu.blogback.tools.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author xiamu
 */
@RestController
@RequestMapping(value = "img")
public class ImgControl {

    private final BlogImgService blogImgService;

    private static final Logger logger = LoggerFactory.getLogger(ImgControl.class);

    @Autowired
    public ImgControl(BlogImgService blogImgService) {
        this.blogImgService = blogImgService;
    }

    /**
     * 上传图片
     * @param upload
     * @param token
     * @return
     */
    @SysLog(value = "上传图片")
    @RequestMapping(value = "/upload")
    public Map<String,Object> imgUpload(@RequestParam(value = "upload") MultipartFile upload,@RequestParam(value = "token") String token){
        logger.info(""+upload.getSize());
        return blogImgService.saveImg(upload,token);
    }

    /**
     * 获取图片列表
     * @return @
     */
    @SysLog(value = "获取图片列表")
    @GetMapping(value = "/list")
    public Result<List<BlogImg>> imgList(){
        return blogImgService.imgList();
    }
}
