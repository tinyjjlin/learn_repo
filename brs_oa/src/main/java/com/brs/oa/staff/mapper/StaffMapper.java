package com.brs.oa.staff.mapper;


import com.brs.oa.ad.entry.Person;
import com.brs.oa.staff.entity.EducationRecord;
import com.brs.oa.staff.entity.TrainRecord;
import com.brs.oa.staff.entity.WorkRecord;
import com.brs.oa.staff.vo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-04
 */
public interface StaffMapper  {


    /**
     * 为员工添加角色
     * @param empNo
     * @param roleNoList
     * @return
     */
    @Insert({
            "<script>",
            "insert into staff_role_relation(emp_no,role_no)values",
            "<foreach collection='roleNoList' item='item' index='index' separator=','>",
            "(#{empNo},#{item})",
            "</foreach>",
            "</script>"
    })
    int appendStaffRole(@Param("empNo")Integer empNo, @Param("roleNoList") List<Integer> roleNoList);

    /**
     * 更新员工头像
     * @param empNo
     * @param imageUrl
     * @return
     */
    int updateStaffHeaderImg(@Param("empNo")Integer empNo, @Param("imageUrl")String imageUrl);

    /**
     * 查询 公司所有员工列表
     * @return
     */
    List <SimpleStaffVo> queryStaffAll();

    /**
     * 根据部门号，查看员工列表
     * @param deptNo
     * @return
     */
    List <SimpleStaffVo> queryStaffByDeptNo(@Param("deptNo")Integer deptNo);

    /**
     * 根据员工号查看员工基本信息
      * @param empNo
     * @return
     */
    SimpleStaffVo  queryStaffByEmpNo(@Param("empNo")Integer empNo);

    /**
     * 根据员工姓名查看员工基本信息
     * @param empName
     * @return
     */
    SimpleStaffVo queryStaffByEmpName(@Param("empName")String empName);

    /**
     * 根据工号，查看员工详细信息
     * @param empNo
     * @return
     */
    StaffDetailInfo queryStaffDetailByEmpNo(@Param("empNo")Integer empNo);


    /**
     * 根据员工姓名，查看员工详细信息
     * @param empName
     * @return
     */
    StaffDetailInfo queryStaffDetailByEmpName(@Param("empName")String empName);

    /**
     * 根据部门号+员工姓名，查看员工详细信息
     * @param deptNo
     * @param empName
     * @return
     */
    StaffDetailInfo queryStaffDetailByDeptNoAndEmpName(@Param("deptNo")Integer deptNo,@Param("empName")String empName);

    /**
     * 一次插入多条数据
     * @param personList
     * @return
     */
    int insert(@Param("list")List<Person> personList);

    /**
     * 更新员工基本信息
     * @return
     */
    int updateBaseInfoByEmpNo(@Param("baseInfo") StaffBaseInfoVo baseInfoVo);

    /**
     * 更新员工重要信息信息
     * @param importantInfoVo
     * @return
     */
    int updateImportantInfoByEmpNo(@Param("importantInfo")StaffImportantInfoVo importantInfoVo);

    /**
     * 插入或更新教育经历（记录）
     * @return
     */
    int insertOrUpdateEduRecord(@Param("eduRecord")EducationRecord educationRecord);

    /**
     * 插入教育经历（记录）
     * @return
     */
    int insertEduRecord(@Param("eduRecord")EducationRecord educationRecord);

    /**
     * 更新教育经历（记录）
     * @return
     */
    int updateEduRecord(@Param("eduRecord")EducationRecord educationRecord);

    /**
     * 根据id删除指定教育经历
     * @param eduRecordId
     * @return
     */
    int deleteEduRecordById(@Param("id")Integer eduRecordId);

    /**
     * 插入工作记录
     * @param workRecord
     * @return
     */
    int insertWorkRecord(@Param("workRecord") WorkRecord workRecord);

    /**
     * 更新工作记录
     * @param workRecord
     * @return
     */
    int updateWorkRecord(@Param("workRecord") WorkRecord workRecord);

    /**
     * 删除工作记录
     * @param workRecordId
     * @return
     */
    int deleteWorkRecord(@Param("id")Integer workRecordId);

    /**
     * 插入培训记录
     * @param trainRecord
     * @return
     */
    int insertTrainRecord(@Param("trainRecord")TrainRecord trainRecord);

    /**
     * 更新培训记录
     * @param trainRecord
     * @return
     */
    int updateTrainRecord(@Param("trainRecord")TrainRecord trainRecord);

    /**
     * 删除培训记录
     * @param trainRecordId
     * @return
     */
    int deleteTrainRecord(@Param("id")Integer trainRecordId);





}
