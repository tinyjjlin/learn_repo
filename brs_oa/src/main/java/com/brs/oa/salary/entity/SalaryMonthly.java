package com.brs.oa.salary.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SalaryMonthly implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 薪资发放日期
     */
    private LocalDate settlementDay;

    /**
     * 员工工号
     */
    private Integer empNo;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

    /**
     * 工作天数系数（正常工作日除以法定每月工作天数21.75）
     */
    private BigDecimal workdayFactor;

    /**
     * 提成
     */
    private BigDecimal commission;

    /**
     * 补贴
     */
    private BigDecimal allowance;

    /**
     * 个人税前工资(合计)
     */
    private BigDecimal payment;

    /**
     * 住房公积金
     */
    private BigDecimal housingFund;

    /**
     * 社保
     */
    private BigDecimal socialInsurance;

    /**
     * 个人所得税
     */
    private BigDecimal taxOfStaff;

    /**
     * 个人税后工资（到手）
     */
    private BigDecimal paymentInHand;

    /**
     * 浮动工资
     */
    private BigDecimal bonusSalary;

    /**
     * 事假扣除
     */
    private BigDecimal deduction;

    /**
     * 个人缴纳社保
     */
    private BigDecimal socialInsuranceOfStaff;

    /**
     * 公司缴纳社保
     */
    private BigDecimal socialInsuranceOfCompany;

    /**
     * 公司支出合计
     */
    private BigDecimal expenditure;

    /**
     * 岗位津贴
     */
    private BigDecimal jobAllowance;

    /**
     * 交通补贴
     */
    private BigDecimal travelAllowance;

    /**
     * 餐费补贴
     */
    private BigDecimal mealAllowance;

    /**
     * 补充说明
     */
    private String description;

    /**
     * 表创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 表修改时间
     */
    private LocalDateTime gmtModified;


}

