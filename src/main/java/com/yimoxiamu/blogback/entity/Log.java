package com.yimoxiamu.blogback.entity;

import java.util.Date;

public class Log {
    private Integer id;

    private Integer user_id;

    private String type;

    private String request_path;

    private String ip;

    private Date create_time;

    private String request_content;

    private String response_content;

    public String getRequest_content() {
        return request_content;
    }

    public void setRequest_content(String request_content) {
        this.request_content = request_content;
    }

    public String getResponse_content() {
        return response_content;
    }

    public void setResponse_content(String response_content) {
        this.response_content = response_content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequest_path() {
        return request_path;
    }

    public void setRequest_path(String request_path) {
        this.request_path = request_path;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}