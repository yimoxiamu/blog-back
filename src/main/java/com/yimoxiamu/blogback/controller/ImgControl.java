package com.yimoxiamu.blogback.controller;

import factory.Log;
import factory.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "img")
public class ImgControl {

    private static final Log logger = LogFactory.getLog(ImgControl.class);

    @RequestMapping(value = "/upload")
    public Map<String,Object> imgUpload(@RequestParam(value = "upload") MultipartFile upload){
        logger.info(upload.getSize());
        Map<String,Object> map = new HashMap<>(16);
        map.put("uploaded",1);
        map.put("fileName","haha.jpg");
        map.put("url","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539941278888&di=5446fa994f83c1a223b88cc563fa779c&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D1562693971%2C2309759221%26fm%3D214%26gp%3D0.jpg");
        return map;
    }
}
