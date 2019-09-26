package com.ank.cms.dao;

import com.ank.cms.model.Group;
import com.ank.cms.model.User;

import java.util.List;

public interface groupMapper {

    List<Group> selAllGroups();

    Group selById(Integer id);

    Group selGroupPermissionsByGID(Integer id);

    int add();

    int edit();

    int remove();
}
