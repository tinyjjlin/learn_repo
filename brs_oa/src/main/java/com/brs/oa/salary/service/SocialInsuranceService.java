package com.brs.oa.salary.service;

import com.brs.oa.salary.entity.SocialInsuranceEntry;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tiny lin
 * @date 2018/12/26
 */
public interface SocialInsuranceService {


    /**
     * 创建社保套账
     * @param siCategory
     * @param siEntryList
     * @return
     */
    int createSITemplate(String siCategory,List<SocialInsuranceEntry> siEntryList);


    /**
     * 发放社保
     * @param settlementDay
     * @param empNoList
     * @return
     */
    int sendSI2Staff(LocalDateTime settlementDay, List<Integer> empNoList);
    /**
     *发放社保
     * @param settlementDay
     * @param siCategory
     * @param empNoList
     * @return
     */
    int sendSI2Staff(LocalDateTime settlementDay, String siCategory, List<Integer> empNoList);

}
