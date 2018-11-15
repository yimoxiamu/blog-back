package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogImg record);

    int insertSelective(BlogImg record);

    BlogImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogImg record);

    int updateByPrimaryKey(BlogImg record);

    List<BlogImg> selectByUserId(@Param(value = "user_id") String user_id);
}