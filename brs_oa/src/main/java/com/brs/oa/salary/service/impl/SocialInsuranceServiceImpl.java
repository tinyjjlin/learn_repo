package com.brs.oa.salary.service.impl;

import com.brs.oa.salary.entity.SocialInsuranceEntry;
import com.brs.oa.salary.entity.SocialInsuranceInfo;
import com.brs.oa.salary.mapper.SocialInsuranceEntryMapper;
import com.brs.oa.salary.mapper.SocialInsuranceInfoMapper;
import com.brs.oa.salary.service.SocialInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tiny lin
 * @date 2018/12/26
 */
@Service
public class SocialInsuranceServiceImpl implements SocialInsuranceService {

    @Autowired(required = false)
    private SocialInsuranceEntryMapper socialInsuranceEntryMapper;
    @Autowired(required = false)
    private SocialInsuranceInfoMapper socialInsuranceInfoMapper;

    @Override
    public int createSITemplate(String siCategory, List <SocialInsuranceEntry> siEntryList) {
        return socialInsuranceEntryMapper.insertOne(siCategory,siEntryList );
    }

    @Override
    public int sendSI2Staff(LocalDateTime settlementDay, List <Integer> empNoList) {
        List<SocialInsuranceInfo> insuranceInfoList  = new ArrayList <>();
        for (Integer empNo : empNoList) {
            insuranceInfoList.add( createPersonSIInfo(settlementDay, empNo,getSIEntryMapByEmpNo(empNo)));
        }
        int result = addSIInfo(insuranceInfoList);
        return result;
    }

    @Override
    public int sendSI2Staff(LocalDateTime settlementDay, String siCategory, List<Integer> empNoList) {
        List<SocialInsuranceInfo> insuranceInfoList  = new ArrayList <>();
        for (Integer empNo : empNoList) {
           insuranceInfoList.add( createPersonSIInfo(settlementDay, empNo, getSIEntryMapByCategory(siCategory)));
        }
        int result = addSIInfo(insuranceInfoList);
        return result;
    }

    public List<SocialInsuranceEntry> getSIEntryByCategory(String siCategory){
        return socialInsuranceEntryMapper.selectListByCategory(siCategory);
    }

    public List<SocialInsuranceEntry> getSIEntryByEmpNo(Integer empNo) {
        return socialInsuranceEntryMapper.selectListByByEmpNo(empNo);
    }

    public  Map<String,SocialInsuranceEntry> getSIEntryMapByEmpNo(Integer empNo){
        List<SocialInsuranceEntry> siEntryList =getSIEntryByEmpNo(empNo);
        Map<String,SocialInsuranceEntry> siEntryMap = new HashMap <>(siEntryList.size());
        for (SocialInsuranceEntry socialInsuranceEntry : siEntryList) {
            siEntryMap.put(socialInsuranceEntry.getItemName(),socialInsuranceEntry );
            System.out.println("社保套账========》"+socialInsuranceEntry.getItemName());
        }
        return siEntryMap;
    }
    public  Map<String,SocialInsuranceEntry> getSIEntryMapByCategory(String siCategory){
        List<SocialInsuranceEntry> siEntryList =getSIEntryByCategory(siCategory);
        Map<String,SocialInsuranceEntry> siEntryMap = new HashMap <>(siEntryList.size());
        for (SocialInsuranceEntry socialInsuranceEntry : siEntryList) {
            siEntryMap.put(socialInsuranceEntry.getItemName(),socialInsuranceEntry );
            System.out.println("社保套账========》"+socialInsuranceEntry.getItemName());
        }
        return siEntryMap;
    }

    public int addSIInfo(List<SocialInsuranceInfo> list){
        return  socialInsuranceInfoMapper.insertList(list);
    }

    /**
     * 创建个人每月社保缴纳信息
     * @param settlementDay
     * @param empNo
     * @param siEntryMap
     * @return
     */
    public SocialInsuranceInfo createPersonSIInfo(LocalDateTime settlementDay,Integer empNo,Map<String,SocialInsuranceEntry> siEntryMap){
        SocialInsuranceInfo personalSIInfo = new SocialInsuranceInfo();
        //社保缴纳月份
        personalSIInfo.setSettlementDay(settlementDay);
        //员工号
        personalSIInfo.setEmpNo(empNo);

        //社保缴纳方式 一： 按固定基数缴纳
        //养老金
        SocialInsuranceEntry pensionEntry =   siEntryMap.get("pension");
        if(pensionEntry.getPayTheWay() == 0){
            personalSIInfo.setPPension(pensionEntry.getBaseNumber().multiply(pensionEntry.getPersonRate()));
            personalSIInfo.setCPension(pensionEntry.getBaseNumber().multiply(pensionEntry.getCompanyRate()));
        }
        //医疗
        SocialInsuranceEntry medicalEntry = siEntryMap.get("medical");
        if(medicalEntry != null && medicalEntry.getPayTheWay() == 0){
            personalSIInfo.setPMedical(medicalEntry.getBaseNumber().multiply(medicalEntry.getPersonRate()));
            personalSIInfo.setCMedical(medicalEntry.getBaseNumber().multiply(medicalEntry.getCompanyRate()));
        }
        //失业
        SocialInsuranceEntry unemploymentEntry = siEntryMap.get("unemployment");
        if(unemploymentEntry != null && unemploymentEntry.getPayTheWay() == 0){
            personalSIInfo.setPUnemployment(unemploymentEntry.getBaseNumber().multiply(unemploymentEntry.getPersonRate()));
            personalSIInfo.setCUnemployment(unemploymentEntry.getBaseNumber().multiply(unemploymentEntry.getCompanyRate()));
        }
        //生育
        SocialInsuranceEntry maternityEntry = siEntryMap.get("maternity");
        if(maternityEntry != null && maternityEntry.getPayTheWay() == 0){
            personalSIInfo.setCMaternity(maternityEntry.getBaseNumber().multiply(maternityEntry.getCompanyRate()));
        }
        //工伤
        SocialInsuranceEntry industrialInjuryEntry = siEntryMap.get("industrial_injury");
        if(industrialInjuryEntry != null && industrialInjuryEntry.getPayTheWay() == 0){
          personalSIInfo.setCIndustrialInjury(industrialInjuryEntry.getBaseNumber().multiply(industrialInjuryEntry.getCompanyRate()));
        }

        //公积金
        SocialInsuranceEntry housingFoundEntry = siEntryMap.get("housing_found");
       if(housingFoundEntry != null && housingFoundEntry.getPayTheWay() == 0){
           personalSIInfo.setPHousingFound(housingFoundEntry.getBaseNumber().multiply(housingFoundEntry.getPersonRate()));
           personalSIInfo.setCHousingFound(housingFoundEntry.getBaseNumber().multiply(housingFoundEntry.getCompanyRate()));
       }

        return personalSIInfo;
    }
}
