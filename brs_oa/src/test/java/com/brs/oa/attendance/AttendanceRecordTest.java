package com.brs.oa.attendance;

import com.alibaba.fastjson.JSONObject;
import com.brs.oa.attendance.mapper.AttendanceRecordMapper;
import com.brs.oa.attendance.vo.AttendanceRecordVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;

import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceRecordTest {

    @Autowired(required = false)
    private AttendanceRecordMapper attendanceRecordMapper;

    @Test
    public  void getList(){

    }


@Test
    public void getList2(){

    }

    @Test
    public void getListRange(){
//        String startTimeStr = "2018-12-17";
//        String endTimeStr = "2018-12-19";
//        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-generator");
//        try {
//            Date startTime = ft.parse(startTimeStr);
//            Date endTime = ft.parse(endTimeStr );
//            List<AttendanceRecordVo> list = attendanceRecordMapper.selectListRange (null,startTime,startTime  );
//            System.out.println(JSONObject.toJSON(list));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
  }
}
