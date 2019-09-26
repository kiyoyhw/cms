package com.ank.cms.model;

import java.util.List;

public class Permission {
    private Integer id;
    private String pname;
    private String description;
    private String pState;
    private List<User> users;
    private List<Group> groups;
    private List<Role> roles;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", description='" + description + '\'' +
                ", pState='" + pState + '\'' +
                ", users=" + users +
                ", groups=" + groups +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Permission() {
    }

    public Permission(Integer id, String pname, String description, String pState, List<User> users, List<Group> groups, List<Role> roles) {
        this.id = id;
        this.pname = pname;
        this.description = description;
        this.pState = pState;
        this.users = users;
        this.groups = groups;
        this.roles = roles;
    }
}
