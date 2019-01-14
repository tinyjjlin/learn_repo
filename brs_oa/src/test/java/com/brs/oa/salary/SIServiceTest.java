package com.brs.oa.salary;

import com.brs.oa.salary.entity.SocialInsuranceEntry;
import com.brs.oa.salary.service.SocialInsuranceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SIServiceTest {

    @Autowired
    private SocialInsuranceService socialInsuranceService;

   @Test
    public void createSITemplate(){
        SocialInsuranceEntry entry1 = new SocialInsuranceEntry();
        entry1.setItemName("pension");
        entry1.setPayTheWay(0);
        entry1.setBaseNumber(BigDecimal.valueOf(200));
        entry1.setPersonRate(BigDecimal.valueOf(0.02));
        entry1.setCompanyRate(BigDecimal.valueOf(0.05));

        List<SocialInsuranceEntry> list  = new ArrayList <>();
        list.add(entry1);
        socialInsuranceService.createSITemplate("滁州五险一金",list );
    }
    @Test
    public void sendSI2Staff(){
        List<Integer> empNoList = new ArrayList <>();
        empNoList.add(100057);

       System.out.println("provide si --------datetime ---->"+LocalDateTime.now());
        socialInsuranceService.sendSI2Staff(    LocalDateTime.now(), "南京五险一金",empNoList );
    }
}
