package com.yimoxiamu.blogback.service;

import com.yimoxiamu.blogback.tools.Result;

import java.util.List;
import java.util.Map;

public interface BlogTypeService {
    /**
     * 获取目前博文类型列表
     * @return list
     */
    Result<List<Map<String,Object>>> getBlogTypeList();
}
