package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.component.CustomGolbalException;
import com.yimoxiamu.blogback.constant.CodeMsg;
import com.yimoxiamu.blogback.service.MainService;
import factory.Log;
import factory.LogFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName MainServiceImpl
 * @Description TODO
 * @Author paw
 * @Email 768840822@qq.com
 * @Date 2018/9/27 11:36
 * @VERSION 1.0
 **/

@Service
@SuppressWarnings("unchecked")
public class MainServiceImpl implements MainService {

    private final static Log log=LogFactory.getLog(MainServiceImpl.class);

    @Override
    public void test() {
        log.info("测试 service");
    }
}
