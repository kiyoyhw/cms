package com.ank.cms.service;

import com.ank.cms.model.base.ResultInfo;

public interface permissionService {
    ResultInfo addByGroupId();

    ResultInfo addByRoleId();

    ResultInfo addByAdminId();
}
