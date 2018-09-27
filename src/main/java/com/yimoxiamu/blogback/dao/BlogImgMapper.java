package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogImg;

public interface BlogImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogImg record);

    int insertSelective(BlogImg record);

    BlogImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogImg record);

    int updateByPrimaryKey(BlogImg record);
}