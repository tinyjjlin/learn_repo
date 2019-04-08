package com.brs.oa.salary.service.impl;

import com.brs.oa.salary.entity.SalaryEntry;
import com.brs.oa.salary.entity.SalaryInfo;
import com.brs.oa.salary.mapper.SalaryEntryMapper;
import com.brs.oa.salary.mapper.SalaryInfoMapper;
import com.brs.oa.salary.service.SalarySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tiny lin
 * @date 2018/12/26
 */
@Service
public class SalaryServiceImpl implements SalarySerivce {


    @Autowired(required = false)
    private SalaryEntryMapper salaryEntryMapper;

    @Autowired(required = false)
    private SalaryInfoMapper salaryInfoMapper;


    @Override
    public int sendSalary2Staff(LocalDateTime issueDate, String salaryTemplateCategory, List <Integer> empNoList) {

        return 0;
    }

    @Override
    public int sendSalary2Staff(LocalDateTime salaryIssueDate, LocalDateTime siDate, List<Integer> empNoList) {
        return 0;
    }

    @Override
    public int sendSalary2Staff(LocalDateTime issueDate, List <Integer> empNoList) {
        return 0;
    }

    /**
     * 创建个人工资信息
     * @return
     */
    private SalaryInfo createPersonSalaryInfo(LocalDateTime issueDate,Integer empNo,Map<String, SalaryEntry> salaryEntryMap){
        SalaryInfo personSalaryInfo = new SalaryInfo();

        personSalaryInfo.setSettlementDay(issueDate);
        personSalaryInfo.setEmpNo(empNo);

        //基本工资
        SalaryEntry baseSalaryEntry = salaryEntryMap.get("basic_salary");
        personSalaryInfo.setBasicSalary(BigDecimal.valueOf(Double.parseDouble(baseSalaryEntry.getItemValue())));

        //提成

        //交通补贴

        //事假

        //病假

        //社保

        //个税

        //奖金



        return personSalaryInfo;
    }

    public List<SalaryEntry> getSalaryEntryListByCategory(String salaryTemplateCateogry){
        return salaryEntryMapper.selectListByCategory(salaryTemplateCateogry);
    }

    public Map<String,SalaryEntry> getSalaryEntryMapByCategory(String salaryTemplateCateogry) {
        List <SalaryEntry> salaryEntryList = getSalaryEntryListByCategory(salaryTemplateCateogry);
        Map <String, SalaryEntry> salaryEntryMap = new HashMap <>(salaryEntryList.size());
        for (SalaryEntry salaryEntry : salaryEntryList) {
            salaryEntryMap.put(salaryEntry.getItemName(), salaryEntry);
        }

        return salaryEntryMap;
    }
}
