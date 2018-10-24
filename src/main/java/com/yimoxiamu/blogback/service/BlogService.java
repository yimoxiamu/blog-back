package com.yimoxiamu.blogback.service;


import com.yimoxiamu.blogback.entity.BlogMain;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;

import java.util.Map;

/**
 * @Author Paw
 */
public interface BlogService {
    /**
     * 获取博客列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result<PageBean> getBlogList(int pageNum, int pageSize);


    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    Result<Map<String,Object>> getBlogInfo(Integer id);

    /**
     * 增加文章喜欢人数
     * @param id
     * @return
     */
    Result<String> addLike(Integer id);

    /**
     * 增加阅读人数
     * @param id
     * @return
     */
    Result<String> addRead(Integer id);

    /**
     * 发表文章
     * @param blogMain
     * @return
     */
    Result<String> pullBlog(BlogMain blogMain);
}
