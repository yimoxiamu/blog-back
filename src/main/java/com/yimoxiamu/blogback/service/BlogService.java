package com.yimoxiamu.blogback.service;


import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;

public interface BlogService {
    Result<PageBean> blogList(int pageNum, int pageSize);
}
