package com.brs.oa.workflow.mapper;


import com.brs.oa.workflow.entity.Workflow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-14
 */
public interface WorkflowMapper {


    int insert(@Param("workflow") Workflow workflow);

    List<Workflow> selectListByApplicant(@Param("applicant")Integer empNo);
    List<Workflow> selectListByApprover(@Param("approver")Integer empNo);

    int update (@Param("approver")Integer empNo,@Param("serialNumber")Integer serialNumber,@Param("approvalStatus")Integer approvalStatus);


}
