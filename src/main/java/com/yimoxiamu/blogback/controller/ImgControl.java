package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.util.IOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "img")
public class ImgControl {

    @Value("${cdn.path}")
    private String floder;

    private static final Logger logger = LoggerFactory.getLogger(ImgControl.class);

    @RequestMapping(value = "/upload")
    public Map<String,Object> imgUpload(@RequestParam(value = "upload") MultipartFile upload){
        logger.info(""+upload.getSize());
        Map<String,Object> map = new HashMap<>(16);
        map.put("uploaded",1);
        map.put("fileName",upload.getOriginalFilename());
        map.put("url",IOUtil.saveImg(upload,floder));
        return map;
    }
}
