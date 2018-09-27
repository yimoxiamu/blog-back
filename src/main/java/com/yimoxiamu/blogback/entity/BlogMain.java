package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class BlogMain {
    private Integer id;

    private Integer typeId;

    private String blogTitle;

    private String blogTitleImg;

    private Date insertTime;

    private Date updateTime;

    private Integer readCount;

    private Integer likeCount;

    private String blogAuth;

    private String blogDescription;

    private String blogInfoUrl;

    private String blogUuid;

    private String nextBlogUuid;

    private String nextBlogTitle;

    private String lastBlogUuid;

    private String lastBlogTitle;

    private String blogStatus;

    private String blogText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogTitleImg() {
        return blogTitleImg;
    }

    public void setBlogTitleImg(String blogTitleImg) {
        this.blogTitleImg = blogTitleImg == null ? null : blogTitleImg.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getBlogAuth() {
        return blogAuth;
    }

    public void setBlogAuth(String blogAuth) {
        this.blogAuth = blogAuth == null ? null : blogAuth.trim();
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription == null ? null : blogDescription.trim();
    }

    public String getBlogInfoUrl() {
        return blogInfoUrl;
    }

    public void setBlogInfoUrl(String blogInfoUrl) {
        this.blogInfoUrl = blogInfoUrl == null ? null : blogInfoUrl.trim();
    }

    public String getBlogUuid() {
        return blogUuid;
    }

    public void setBlogUuid(String blogUuid) {
        this.blogUuid = blogUuid == null ? null : blogUuid.trim();
    }

    public String getNextBlogUuid() {
        return nextBlogUuid;
    }

    public void setNextBlogUuid(String nextBlogUuid) {
        this.nextBlogUuid = nextBlogUuid == null ? null : nextBlogUuid.trim();
    }

    public String getNextBlogTitle() {
        return nextBlogTitle;
    }

    public void setNextBlogTitle(String nextBlogTitle) {
        this.nextBlogTitle = nextBlogTitle == null ? null : nextBlogTitle.trim();
    }

    public String getLastBlogUuid() {
        return lastBlogUuid;
    }

    public void setLastBlogUuid(String lastBlogUuid) {
        this.lastBlogUuid = lastBlogUuid == null ? null : lastBlogUuid.trim();
    }

    public String getLastBlogTitle() {
        return lastBlogTitle;
    }

    public void setLastBlogTitle(String lastBlogTitle) {
        this.lastBlogTitle = lastBlogTitle == null ? null : lastBlogTitle.trim();
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus == null ? null : blogStatus.trim();
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText == null ? null : blogText.trim();
    }
}