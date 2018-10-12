package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class BlogMain {
    private Integer id;

    private String blog_uuid;

    private Integer type_id;

    private String blog_title;

    private String blog_description;

    private Integer comment_id;

    private Integer read_count;

    private Integer like_count;

    private String blog_status;

    private Integer create_by;

    private Date create_time;

    private Integer update_by;

    private Date update_time;

    private String delfalg;

    private Date del_date;

    private String blog_text;

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

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_description() {
        return blog_description;
    }

    public void setBlog_description(String blog_description) {
        this.blog_description = blog_description;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getRead_count() {
        return read_count;
    }

    public void setRead_count(Integer read_count) {
        this.read_count = read_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getBlog_status() {
        return blog_status;
    }

    public void setBlog_status(String blog_status) {
        this.blog_status = blog_status;
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

    public Integer getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Integer update_by) {
        this.update_by = update_by;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getDelfalg() {
        return delfalg;
    }

    public void setDelfalg(String delfalg) {
        this.delfalg = delfalg;
    }

    public Date getDel_date() {
        return del_date;
    }

    public void setDel_date(Date del_date) {
        this.del_date = del_date;
    }

    public String getBlog_text() {
        return blog_text;
    }

    public void setBlog_text(String blog_text) {
        this.blog_text = blog_text;
    }
}