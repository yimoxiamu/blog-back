package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class BlogComment {
    private Integer id;

    private String blogComment;

    private String blogUuid;

    private Date pullTime;

    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(String blogComment) {
        this.blogComment = blogComment == null ? null : blogComment.trim();
    }

    public String getBlogUuid() {
        return blogUuid;
    }

    public void setBlogUuid(String blogUuid) {
        this.blogUuid = blogUuid == null ? null : blogUuid.trim();
    }

    public Date getPullTime() {
        return pullTime;
    }

    public void setPullTime(Date pullTime) {
        this.pullTime = pullTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}