package com.brs.oa.workflow.entity;

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
 * @since 2019-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Workflow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private Integer serialNumber;

    /**
     * 工作名称
     */
    private String workName;

    /**
     * 申请人
     */
    private Integer  applicant;

    /**
     * 审批人
     */
    private Integer approver;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结算时间
     */
    private LocalDateTime endTime;

    /**
     * 内容

     */
    private String content;

    /**
     * 工作流类型
     */
    private Integer flowType;

    /**
     * 申请时间
     */
    private LocalDateTime applicationTime;

    /**
     * 审批状态
0代表未通过，1已经通过，2拒绝
     */
    private Integer approvalStatus;

    /**
     * 审批时间
     */
    private LocalDateTime approvalTime;

    /**
     *  证明图片
     */
    private String proveImg;




}
