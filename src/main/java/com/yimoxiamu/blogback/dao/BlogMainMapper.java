package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogMain;

public interface BlogMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogMain record);

    int insertSelective(BlogMain record);

    BlogMain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogMain record);

    int updateByPrimaryKeyWithBLOBs(BlogMain record);

    int updateByPrimaryKey(BlogMain record);
}