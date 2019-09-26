package com.ank.cms.model;

import java.util.Date;
import java.util.List;

public class Group {

    private Integer id;
    private String gname;
    private String description;
    private Date create_time;
    private String author;
    private List<User> users;
    private List<Permission> permissions;


    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", author='" + author + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Group() {
    }

    public Group(Integer id, String gname, String description, Date create_time, String author) {
        this.id = id;
        this.gname = gname;
        this.description = description;
        this.create_time = create_time;
        this.author = author;
    }

    public Group(Integer id, String gname, String description, Date create_time, String author, List<User> users, List<Permission> permissions) {
        this.id = id;
        this.gname = gname;
        this.description = description;
        this.create_time = create_time;
        this.author = author;
        this.users = users;
        this.permissions = permissions;
    }
}
