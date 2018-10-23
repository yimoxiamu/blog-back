package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.component.CustomGolbalException;
import com.yimoxiamu.blogback.component.GlobalException;
import com.yimoxiamu.blogback.dao.BlogMainMapper;
import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import factory.Log;
import factory.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BlogServiceImpl
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/28 13:44
 * @VERSION 1.0
 **/
@Service
public class BlogServiceImpl implements BlogService {

    private static final Log log = LogFactory.getLog(BlogServiceImpl.class);

    private final BlogMainMapper blogMainMapper;

    @Autowired(required = false)
    public BlogServiceImpl(BlogMainMapper blogMainMapper) {
        this.blogMainMapper = blogMainMapper;
    }


    @Override
    public Result<PageBean> getBlogList(int pageNum, int pageSize) {
        PageBean<Map<String,Object>> pageBean=PageBean.setUp(pageNum,pageSize).doSelect(blogMainMapper::blogList);
        return Result.success(pageBean);
    }

    @Override
    public Result<String> addLike(Integer id) {
        int i = blogMainMapper.updateLikeCount(id);
        if(i != 1){
            throw new CustomGolbalException(CodeMsg.ADD_LIKE_ERROR);
        }
        return Result.success("增加喜欢人数成功");
    }

    @Override
    public Result<Map<String, Object>> getBlogInfo(Integer id) {
        Map<String,Object> blogInfo = blogMainMapper.selectBlogById(id);
        List<Map<String,Object>> contextualInfo = blogMainMapper.getContextualById(id);
        Map<String,Object> retMap = new HashMap<>(16);
        retMap.put("blogInfo",blogInfo);
        retMap.put("contextualInfo",contextualInfo);
        return Result.success(retMap);
    }
}
