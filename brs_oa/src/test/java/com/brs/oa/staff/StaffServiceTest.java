package com.brs.oa.staff;

import com.brs.oa.staff.service.IStaffService;

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
public class StaffServiceTest {

    @Autowired
    private IStaffService staffService;

  @Test
    public void getPageList(){

    }
}
