package com.yimoxiamu.blogback.controller;

import com.yimoxiamu.blogback.service.BlogTypeService;
import com.yimoxiamu.blogback.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author xiamu
 */
@RestController
@RequestMapping(value = "/type")
public class BlogTypeControl {

    private final BlogTypeService blogTypeService;

    @Autowired
    public BlogTypeControl(BlogTypeService blogTypeService) {
        this.blogTypeService = blogTypeService;
    }

    @GetMapping(value = "/typeList")
    public Result<List<Map<String,Object>>> typeList(){
        return blogTypeService.getBlogTypeList();
    }
}
