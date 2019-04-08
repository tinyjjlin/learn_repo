package com.brs.oa.workflow.service;


import com.brs.oa.workflow.entity.Workflow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tiny lin
 * @since 2019-01-14
 */
public interface IWorkflowService  {


    int add( Workflow workflow);
    List<Workflow> getListByApplicant(Integer empNo);
    List<Workflow> getListByApprover(Integer empNo);
    int approval (Integer empNo,Integer serialNumber,Integer approvalStatus);

}
