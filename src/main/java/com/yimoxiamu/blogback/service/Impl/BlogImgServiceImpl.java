package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.dao.BlogImgMapper;
import com.yimoxiamu.blogback.entity.BlogImg;
import com.yimoxiamu.blogback.service.BlogImgService;
import com.yimoxiamu.blogback.tools.Result;
import com.yimoxiamu.blogback.util.IOUtil;
import com.yimoxiamu.blogback.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName BlogImgServiceImpl
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/10/25 9:52
 * @VERSION 1.0
 **/
@Service
public class BlogImgServiceImpl implements BlogImgService {
    private final BlogImgMapper blogImgMapper;

    @Value("${cdn.path}")
    private String floder;

    @Autowired(required = false)
    public BlogImgServiceImpl(BlogImgMapper blogImgMapper) {
        this.blogImgMapper = blogImgMapper;
    }

    @Override
    public Map<String, Object> saveImg(MultipartFile file, String token) {
        String imgWebUrl = IOUtil.saveImg(file,floder);

        BlogImg blogImg = new BlogImg();
        blogImg.setImg_url(imgWebUrl);
        blogImg.setImg_type(1);
        blogImg.setUser_id(Integer.valueOf(Objects.requireNonNull(TokenUtil.getUserId(token) == null ? "1" : TokenUtil.getUserId())));
        blogImgMapper.insertSelective(blogImg);
        Map<String,Object> map = new HashMap<>(16);
        map.put("uploaded",1);
        map.put("fileName",file.getOriginalFilename());
        map.put("url",imgWebUrl);
        return map;
    }

    @Override
    public Result<List<BlogImg>> imgList() {
//        String userId = TokenUtil.getUserId();
        String userId = "1";
        List<BlogImg> imgUrlList = blogImgMapper.selectByUserId(userId);
        return Result.success(imgUrlList);
    }
}
