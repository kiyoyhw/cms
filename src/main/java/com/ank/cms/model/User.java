package com.ank.cms.model;

import java.util.Date;
import java.util.List;

public class User {
    private Integer id;
    private String group_id;
    private String username;
    private String password;
    private String mobile;
    private Date last_login_time;
    private Date create_time;
    private Integer count;
    private Integer state;
    private List<Group> groups;
    private List<Permission> permissions;
    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", group_id='" + group_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", last_login_time=" + last_login_time +
                ", create_time=" + create_time +
                ", count=" + count +
                ", state=" + state +
                ", groups=" + groups +
                ", permissions=" + permissions +
                ", role=" + role +
                '}';
    }

    public User() {
    }

    public User(Integer id, String group_id, String username, String password, String mobile, Date last_login_time, Date create_time, Integer count, Integer state) {
        this.id = id;
        this.group_id = group_id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.last_login_time = last_login_time;
        this.create_time = create_time;
        this.count = count;
        this.state = state;
    }

    public User(Integer id, String group_id, String username, String password, String mobile, Date last_login_time, Date create_time, Integer count, Integer state, List<Group> groups, List<Permission> permissions, Role role) {
        this.id = id;
        this.group_id = group_id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.last_login_time = last_login_time;
        this.create_time = create_time;
        this.count = count;
        this.state = state;
        this.groups = groups;
        this.permissions = permissions;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

