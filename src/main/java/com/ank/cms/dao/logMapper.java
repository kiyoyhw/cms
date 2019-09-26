package com.ank.cms.dao;

import com.ank.cms.model.Group;

import java.util.List;

public interface logMapper {

    List<Group> selAllGroups();

    Group selById(Integer id);

    int add();

    int edit();

    int remove();
}
