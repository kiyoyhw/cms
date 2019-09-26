package com.ank.cms.service.iml;

import com.ank.cms.model.User;
import com.ank.cms.model.base.ResultInfo;
import com.ank.cms.service.userService;
import com.ank.cms.util.ITools;
import com.ank.cms.util.ToolsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class userServiceImpl implements userService {

    private final Logger logger = LoggerFactory.getLogger(userServiceImpl.class);

    private final ITools tools = ToolsFactory.CreateTools();

    @Override
    public ResultInfo<User> login(Map map) {
        return null;
    }

    @Override
    public ResultInfo<User> regist(Map map) {
        return null;
    }
}
