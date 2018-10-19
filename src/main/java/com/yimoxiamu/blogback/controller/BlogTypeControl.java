package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.BlogTypeService;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/type")
public class BlogTypeControl {

    @Autowired
    private BlogTypeService blogTypeService;

    @GetMapping(value = "/typeList")
    public Result<List<Map<String,Object>>> typeList(){
        return blogTypeService.getBlogTypeList();
    }
}
