package com.brs.oa.permission;

import com.brs.oa.permission.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tiny lin
 * @date 2018/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    private IPermissionService permissionService;

    @Test
    public void getPermissionListByEmpNo(){
        permissionService.getPermissionList(100057);
    }
}
