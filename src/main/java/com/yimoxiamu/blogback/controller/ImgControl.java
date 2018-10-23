package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.util.IOUtil;
import factory.Log;
import factory.LogFactory;
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

    private static final Log logger = LogFactory.getLog(ImgControl.class);

    @RequestMapping(value = "/upload")
    public Map<String,Object> imgUpload(@RequestParam(value = "upload") MultipartFile upload){
        logger.info(upload.getSize());
        Map<String,Object> map = new HashMap<>(16);
        map.put("uploaded",1);
        map.put("fileName","haha.jpg");
        map.put("url",IOUtil.saveImg(upload,floder));
        return map;
    }
}
