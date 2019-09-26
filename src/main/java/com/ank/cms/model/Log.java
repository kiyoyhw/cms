package com.ank.cms.model;

import java.util.Date;

public class Log {
    private Integer id;
    private String type;
    private String content;
    private Date operation_time;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", operation_time=" + operation_time +
                '}';
    }

    public Log() {
    }

    public Log(Integer id, String type, String content, Date operation_time) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.operation_time = operation_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }
}
