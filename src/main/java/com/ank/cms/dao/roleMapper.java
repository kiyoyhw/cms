package com.ank.cms.dao;

import com.ank.cms.model.*;

import java.util.List;

public interface roleMapper {

    Role selById(Integer id);

    List<User> selUsersByRID(Integer id);

    List<Permission> selPermissionsByRID(Integer id);

    int add();

    int edit();

    int remove();
}
