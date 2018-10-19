package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogType;

import java.util.List;
import java.util.Map;

public interface BlogTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogType record);

    int insertSelective(BlogType record);

    BlogType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogType record);

    int updateByPrimaryKey(BlogType record);

    List<Map<String,Object>> selectBlogTypeList();
}