package com.brs.oa.permission.entity;

import java.sql.Timestamp;
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
 * @since 2018-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer permissionNo;

    private String permissionName;

    private String permissionCode;

    private Integer isEnabled;

    /**
     * 表创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 表修改时间
     */
    private Timestamp gmtModified;


}
