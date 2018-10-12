package com.yimoxiamu.blogback.service;


import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;

public interface BlogService {
    /**
     * 获取博客列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result<PageBean> getBlogList(int pageNum, int pageSize);

    /**
     * 增加对应文章喜欢人数
     * @param uuid
     * @param likeCount
     * @return result
     */
    Result<String> addLike(String uuid,int likeCount);

}
