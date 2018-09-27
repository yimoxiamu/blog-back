package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.TType;

public interface TTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TType record);

    int insertSelective(TType record);

    TType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TType record);

    int updateByPrimaryKey(TType record);
}