package com.brs.oa.salary.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工社保（五险一金）信息
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SocialInsuranceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发放日期
     */
    private LocalDateTime settlementDay;

    /**
     * 员工号
     */
    private Integer empNo;

    /**
     * 个人养应缴养老保险金
     */
    private BigDecimal pPension;

    /**
     * 公司应缴养老保险金
     */
    private BigDecimal cPension;

    /**
     * 个人应缴医疗保险金
     */
    private BigDecimal pMedical;

    /**
     * 公司应缴医疗保险金
     */
    private BigDecimal cMedical;

    /**
     * 个人应缴失业保险
     */
    private BigDecimal pUnemployment;

    /**
     * 公司应缴失业保险金
     */
    private BigDecimal cUnemployment;

    /**
     * 公司应缴工伤保险金
     */
    private BigDecimal cIndustrialInjury;

    /**
     * 公司应缴生育保险金
     */
    private BigDecimal cMaternity;

    /**
     * 个人应缴住房公积金
     */
    private BigDecimal pHousingFound;

    /**
     * 公司应缴住房公积金
     */
    private BigDecimal cHousingFound;


}
