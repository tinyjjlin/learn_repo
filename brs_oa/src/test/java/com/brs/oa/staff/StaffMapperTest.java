package com.brs.oa.staff;

import com.brs.oa.staff.entity.EducationRecord;
import com.brs.oa.staff.mapper.StaffMapper;
import com.brs.oa.staff.vo.StaffDetailInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffMapperTest {

    @Autowired(required = false)
    private StaffMapper staffMapper;

    @Test
    public void test(){
        StaffDetailInfo staffDetailInfo = staffMapper.queryStaffDetailByEmpNo(100057);
        System.out.println("emp no --->"+staffDetailInfo.getEmpNo()+"name-->"+staffDetailInfo.getName());
        List<EducationRecord> educationRecords = staffDetailInfo.getEducationRecordList();
        System.out.println("education record:"+educationRecords.size());
        for (EducationRecord educationRecord : educationRecords) {
            System.out.println(educationRecord.getDiplomas());
        }
    }
}
