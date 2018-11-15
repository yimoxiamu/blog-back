package com.yimoxiamu.blogback.service;

import com.yimoxiamu.blogback.entity.BlogImg;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface BlogImgService {
    /**
     * 保存图片
     * @return
     */
    Map<String,Object> saveImg(MultipartFile file,String token);

    /**
     * 图片列表
     * @return
     */
    Result<List<BlogImg>> imgList();
}
