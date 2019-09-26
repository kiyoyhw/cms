package com.ank.cms.dao;

import com.ank.cms.model.Permission;
import com.ank.cms.model.Role;

import java.util.List;

public interface permissionMapper {

    List<Permission> selPermissions();

    List<Permission> selUserPermissionsByUID(Integer id);

    List<Permission> selGroupPermissionsByGID(Integer id);

    List<Permission> selRolePermissionsByRID(Integer id);

    Permission selById(Integer id);

    int add();

    int edit();

    int remove();
}
