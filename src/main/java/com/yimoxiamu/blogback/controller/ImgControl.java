package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.BlogImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping(value = "img")
public class ImgControl {

    @Autowired
    private BlogImgService blogImgService;

    private static final Logger logger = LoggerFactory.getLogger(ImgControl.class);

    @RequestMapping(value = "/upload")
    public Map<String,Object> imgUpload(@RequestParam(value = "upload") MultipartFile upload,@RequestParam(value = "token") String token){
        logger.info(""+upload.getSize());
        return blogImgService.saveImg(upload,token);
    }
}
