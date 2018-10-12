package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class BlogType {
    private Integer id;

    private String blog_type;

    private Integer count;

    private String delflag;

    private Date del_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlog_type() {
        return blog_type;
    }

    public void setBlog_type(String blog_type) {
        this.blog_type = blog_type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public Date getDel_date() {
        return del_date;
    }

    public void setDel_date(Date del_date) {
        this.del_date = del_date;
    }
}