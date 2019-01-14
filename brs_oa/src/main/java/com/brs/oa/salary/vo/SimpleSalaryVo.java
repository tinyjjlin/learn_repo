package com.brs.oa.salary.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 个人工资条视图数据
 * @author tiny lin
 * @date 2018/12/4
 */
@Data
public class SimpleSalaryVo {

    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 日期 工资发放时间
     */
    private LocalDate settlementDay;
    /**
     * 基本工资
     */
    private BigDecimal basicSalary;

    /**
     * 工作天数系数
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
     * 个人税前工资 （合计）
     */
    private BigDecimal payment;

    /**
     * 住房公积金
     */
    private BigDecimal housingFund;


    /**
     * 社保（包括个人缴纳，公司缴纳）
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



}
