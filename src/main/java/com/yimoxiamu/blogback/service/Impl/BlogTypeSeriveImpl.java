package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.dao.BlogTypeMapper;
import com.yimoxiamu.blogback.service.BlogTypeService;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xiamu
 */
@Service
public class BlogTypeSeriveImpl implements BlogTypeService {

    private final BlogTypeMapper blogTypeMapper;

    @Autowired(required = false)
    public BlogTypeSeriveImpl(BlogTypeMapper blogTypeMapper) {
        this.blogTypeMapper = blogTypeMapper;
    }


    @Override
    public Result<List<Map<String, Object>>> getBlogTypeList() {
        List<Map<String,Object>> typeList = blogTypeMapper.selectBlogTypeList();
        return Result.success(typeList);
    }
}
