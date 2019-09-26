package com.ank.cms.model;

import java.util.Date;
import java.util.List;

public class Role {
    private Integer id;
    private String rname;
    private String description;
    private Date create_time;
    private String author;
    private List<Permission> permissions;
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", author='" + author + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(Integer id, String rname, String description, Date create_time, String author) {
        this.id = id;
        this.rname = rname;
        this.description = description;
        this.create_time = create_time;
        this.author = author;
    }

    public Role(Integer id, String rname, String description, Date create_time, String author, List<Permission> permissions, List<User> users) {
        this.id = id;
        this.rname = rname;
        this.description = description;
        this.create_time = create_time;
        this.author = author;
        this.permissions = permissions;
        this.users = users;
    }
}
