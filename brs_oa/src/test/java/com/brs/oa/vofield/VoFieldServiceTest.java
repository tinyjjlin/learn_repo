package com.brs.oa.vofield;

import com.brs.oa.vofield.service.IVoFieldService;
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
public class VoFieldServiceTest {
    @Autowired
    private IVoFieldService voFieldService;
    
    @Test
    public  void getFieldList(){
        voFieldService.getFieldListByEmpNoAndVoName(100057, "SimpleStaffVo");

    }

}
