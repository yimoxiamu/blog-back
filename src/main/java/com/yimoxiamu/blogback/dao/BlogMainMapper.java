package com.yimoxiamu.blogback.dao;

import com.yimoxiamu.blogback.entity.BlogMain;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过id查询文章详情
     * @return
     */
    Map<String,Object> selectBlogById(@Param(value = "id") Integer id);

    /**
     * 通过id查找文章上下文详情
     * @param id
     * @return
     */
    List<Map<String,Object>> getContextualById(@Param(value = "id") Integer id);

    /**
     * 增加文章喜欢人数
     * @param id
     * @return
     */
    int updateLikeCount(@Param(value = "id") Integer id);
}