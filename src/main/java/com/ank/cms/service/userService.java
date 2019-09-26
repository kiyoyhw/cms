package com.ank.cms.service;

import com.ank.cms.model.User;
import com.ank.cms.model.base.ResultInfo;

import java.util.Map;

public interface userService {

    ResultInfo<User> login(Map<String, String> map);

    ResultInfo<User> regist(Map<String, String> map);
}
