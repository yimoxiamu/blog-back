package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.dao.BlogTypeMapper;
import com.yimoxiamu.blogback.service.BlogTypeService;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogTypeSeriveImpl implements BlogTypeService {

    @Autowired(required = false)
    private BlogTypeMapper blogTypeMapper;


    @Override
    public Result<List<Map<String, Object>>> getBlogTypeList() {
        List<Map<String,Object>> typeList = blogTypeMapper.selectBlogTypeList();
        return Result.success(typeList);
    }
}
