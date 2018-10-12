package com.yimoxiamu.blogback.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yimoxiamu.blogback.dao.BlogMainMapper;
import com.yimoxiamu.blogback.entity.BlogMain;
import com.yimoxiamu.blogback.service.BlogService;
import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.PageBean;
import com.yimoxiamu.blogback.tools.Result;
import com.yimoxiamu.blogback.tools.SelectSql;
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

    @Autowired(required = false)
    private BlogMainMapper blogMainMapper;


    @Override
    public Result<PageBean> getBlogList(int pageNum, int pageSize) {
        PageBean<Map<String,Object>> pageBean=PageBean.setUp(pageNum,pageSize).doSelect(() -> { blogMainMapper.blogList(); });
        return Result.success(pageBean);
    }

    @Override
    public Result<String> addLike(String uuid,int likeCount) {
//        int i = blogMainMapper.addLikeCount(uuid,likeCount);
//        if(i != 1){
//            return Result.error(CodeMsg.ADD_LIKE_ERROR);
//        }
        return Result.success("ok");
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
