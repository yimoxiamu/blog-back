package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class BlogComment {
    private Integer id;

    private String blog_uuid;

    private String blog_comment;

    private Integer comment_count;

    private Integer create_by;

    private Date create_time;

    private String delflag;

    private Date del_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlog_uuid() {
        return blog_uuid;
    }

    public void setBlog_uuid(String blog_uuid) {
        this.blog_uuid = blog_uuid;
    }

    public String getBlog_comment() {
        return blog_comment;
    }

    public void setBlog_comment(String blog_comment) {
        this.blog_comment = blog_comment;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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