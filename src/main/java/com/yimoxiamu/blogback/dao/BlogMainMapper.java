package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogMain;

import java.util.List;
import java.util.Map;

public interface BlogMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogMain record);

    int insertSelective(BlogMain record);

    BlogMain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogMain record);

    int updateByPrimaryKeyWithBLOBs(BlogMain record);

    int updateByPrimaryKey(BlogMain record);

    /**
     * 获取文章列表
     * @return
     */
    List<Map<String,Object>> blogList();
}