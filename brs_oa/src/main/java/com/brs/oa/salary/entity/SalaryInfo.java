package com.brs.oa.salary.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工工资信息
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalaryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发放日期
     */
    private LocalDateTime settlementDay;

    /**
     * 员工工号

     */
    private Integer empNo;

    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

    /**
     * 工作天数系数（正常工作日除以法定每月工作天数21.75）
     */
    private BigDecimal workdayFactor;

    /**
     * 订单提成
     */
    private BigDecimal commission;

    /**
     * 交通补贴
     */
    private BigDecimal travelAllowance;

    /**
     * 事假扣除
     */
    private BigDecimal deduction;

    /**
     * 个人税前工资(合计)
     */
    private BigDecimal payment;

    /**
     * 个人缴纳社保
     */
    private BigDecimal socialInsuranceOfStaff;

    /**
     * 公司缴纳社保
     */
    private BigDecimal socialInsuranceOfCompany;

    /**
     * 个人所得税
     */
    private BigDecimal taxOfStaff;

    /**
     * 公司支出合计
     */
    private BigDecimal expenditure;

    /**
     * 个人税后工资（到手）
     */
    private BigDecimal paymentInHand;

    /**
     * 全勤奖
     */
    private BigDecimal attendanceBonus;


}
