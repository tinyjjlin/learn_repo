package com.brs.oa.attendance.service.impl;


import com.brs.oa.attendance.service.IAttendanceRecordService;
import com.brs.oa.attendance.vo.AttendanceRecordVo;

import com.brs.oa.clockrecord.service.IClockRecordService;
import com.brs.oa.clockrecord.vo.ClockRecordVo;
import com.brs.oa.holidayschedule.entity.HolidaySchedule;
import com.brs.oa.holidayschedule.service.IHolidayScheduleService;
import com.brs.oa.schedule.service.IScheduleService;
import com.brs.oa.util.CalendarSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;


/**
 * <p>
 * 考勤（打卡）记录 服务实现类
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-18
 */
@Service
public class AttendanceRecordServiceImpl  implements IAttendanceRecordService {


    @Autowired(required = false)
    private IClockRecordService clockRecordService;

    @Autowired
    private IScheduleService scheduleService;

    @Autowired
    private IHolidayScheduleService holidayScheduleService;



    @Override
    public List <AttendanceRecordVo> getRecordListByMonth(Integer empNo, String selectedMonth) {
         int[] dateArr = CalendarSupport.getYearAndMonth(selectedMonth);
         int year = dateArr[0];
         int month = dateArr[1];

         //step 选择的月份是否为过去月份，
         int maxDay = CalendarSupport.getMaxDayByDate(year,month);
         // 指定月份的考勤数据
         HashMap<String,AttendanceRecordVo> attendanceRecordVoMap = new HashMap <>(maxDay);

         // 节假日考勤对象
        AttendanceRecordVo holidayAttendanceObj = new AttendanceRecordVo();
        holidayAttendanceObj.setDayType(2);
        //休息日考勤对象
        AttendanceRecordVo restDayAttendanceObj = new AttendanceRecordVo();
        restDayAttendanceObj.setDayType(1);



         List<HolidaySchedule> holidayScheduleList  = holidayScheduleService.selectListByMonth(month);
         if(holidayScheduleList != null && holidayScheduleList.size()>0){
             // 请假日
             for (HolidaySchedule holidaySchedule : holidayScheduleList) {
                 //节假日
                    if(holidaySchedule.getHType() == 2){
                        attendanceRecordVoMap.put(holidaySchedule.getHDay(),holidayAttendanceObj);
                    }
                    //调休加班
                    if(holidaySchedule.getHType() == 0){
                        attendanceRecordVoMap.put(holidaySchedule.getHDay(),null);
                    }
             }
         }

        for(int i=0;i<maxDay;i++){
            String dateStr = CalendarSupport.getDateStr(year, month, i);
            //去除节假日，调休加班（星期六，星期天）添加休息日
            if(!attendanceRecordVoMap.containsKey(dateStr)){
                if(CalendarSupport.isRestDay(CalendarSupport.strToDate(CalendarSupport.getDateStr(year, month, i)))){
                    attendanceRecordVoMap.put(dateStr, restDayAttendanceObj);
                }
                //正常工作日
                attendanceRecordVoMap.put(CalendarSupport.getDateStr(year, month, i), null);
            }
        }

        //添加工作日考勤数据
        List<ClockRecordVo>  clockRecordVoList = clockRecordService.selectClockRecordListByMonth(empNo, selectedMonth);
        for (int j=0;j<clockRecordVoList.size();j++){
            ClockRecordVo clockRecordVo= clockRecordVoList.get(j);
            //日期格式问题
            clockRecordVo.getClockDay();
        }




        return null;
    }




}
