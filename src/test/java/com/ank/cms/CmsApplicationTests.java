package com.ank.cms;

import com.ank.cms.dao.groupMapper;
import com.ank.cms.model.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {

    @Autowired
    private groupMapper groupMapper;

    @Test
    public void tsts() {
        Group group = groupMapper.selGroupPermissionsByGID(1);
        System.out.println(group);
    }
}
