package com.brs.oa.salary.service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/26
 */
public interface SalarySerivce {

    /**
     * 向员工发放工资
     * @param salaryIssueDate 工资发放日期
     * @param siDate 社保发放日期
     * @param empNoList 员工列表
     * @return
     */
    int sendSalary2Staff(LocalDateTime salaryIssueDate,LocalDateTime  siDate, List<Integer> empNoList);

    /**
     * 向员工发放工资
     * @param issueDate
     * @param empNoList
     * @return
     */
    int sendSalary2Staff(LocalDateTime issueDate, List<Integer> empNoList);

    /**
     *  向员工发放工资
     * @param issueDate
     * @param salaryTemplateCategory 工资套帐类别
     * @param empNoList
     * @return
     */
    int sendSalary2Staff(LocalDateTime issueDate,String salaryTemplateCategory ,List<Integer> empNoList);
}
