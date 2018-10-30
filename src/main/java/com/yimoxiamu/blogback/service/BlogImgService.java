package com.yimoxiamu.blogback.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface BlogImgService {
    /**
     * 保存图片
     * @return
     */
    Map<String,Object> saveImg(MultipartFile file,String token);
}
