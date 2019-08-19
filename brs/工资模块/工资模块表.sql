## brs_oa db
CREATE DATABASE  if not exists `brs_oa_sys` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
use brs_oa_sys;
## 1 salary_mothly
CREATE TABLE  if not exists `salary_monthly` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emp_no` int(11) NOT NULL COMMENT '员工工号',
  `settlement_day` date NOT NULL COMMENT '日期',
  `basic_salary` decimal(10,2) NOT NULL COMMENT '基本工资',
  `bonus_salary` decimal(10,2) NOT NULL COMMENT '浮动工资',
  `commission` decimal(10,2) NOT NULL COMMENT '提成',
  `deduction` decimal(10,2) NOT NULL COMMENT '事假扣除',
  `payment` decimal(10,2) NOT NULL COMMENT '个人税前工资',
  `social_insurance_of_staff` decimal(10,2) NOT NULL COMMENT '个人缴纳社保',
  `tax_of_staff` decimal(10,2) NOT NULL COMMENT '个人所得税',
  `payment_in_hand` decimal(10,2) NOT NULL COMMENT '个人税后工资（到手）',
  `social_insurance_of_company` decimal(10,2) NOT NULL COMMENT '公司缴纳社保',
  `expenditure` decimal(10,2) NOT NULL COMMENT '公司支出合计',
  `description` varchar(1200) NOT NULL COMMENT '补充说明',
  `job_allowance` decimal(10,2) NOT NULL COMMENT '岗位津贴',
  `travel_allowance` decimal(10,2) NOT NULL COMMENT '交通补贴',
  `meal_allowance` decimal(10,2) NOT NULL COMMENT '餐费补贴',
  `gmt_create` datetime DEFAULT NULL COMMENT '表创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 2 staff
CREATE TABLE  if not exists  `staff` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emp_no` int(11) NOT NULL,
  `domain_guid` binary(16) DEFAULT NULL COMMENT '域账户objectGUID',
  `name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `dept_no` int(11) DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `nation` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `politics_status` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `highest_degree` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `marital_status` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `mobile` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `current_address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `nation_idcard` varchar(36) DEFAULT NULL COMMENT '中华人民共和国身份证号',
  `position` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `gender`  tinyint(4) unsigned DEFAULT '0',
  `picture` varchar(60) DEFAULT NULL COMMENT '员工头像',
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;


## 3 staff role
CREATE TABLE  if not exists  `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_no` int(11) DEFAULT NULL,
  `role_desc` varchar(50) DEFAULT NULL,
  `is_enabled` tinyint(4) DEFAULT '1',
  `role_name` varchar(10) NOT NULL,
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

## 4  staff role relation
CREATE TABLE   if not exists `staff_role_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emp_no` int(11) NOT NULL,
  `role_no` int(11) NOT NULL,
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT  CHARSET=utf8mb4;

## 5permission
CREATE TABLE  if not exists `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `permission_no` int(11) NOT NULL,
  `permission_name` varchar(30) NOT NULL,
  `permission_code` varchar(100) DEFAULT NULL,
  `is_enabled`  tinyint(4) DEFAULT '1',
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

## 6 role permission relation
CREATE TABLE  if not exists `role_permission_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_no` int(11) NOT NULL,
  `permission_no` int(11) NOT NULL,
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



## 7 department
CREATE TABLE  if not exists `department` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dept_no` int(11) NOT NULL,
  `dept_name` varchar(20) NOT NULL,
  `parent_no` int(11) DEFAULT NULL,
  `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


## 8 vo field
CREATE TABLE  if not exists `vo_field` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `field_name` varchar(45) DEFAULT NULL,
  `field_desc` varchar(45) DEFAULT NULL,
  `field_type` varchar(45) DEFAULT NULL,
  `from_vo` varchar(45) DEFAULT NULL,
  `field_no` int(11) NOT NULL,
    `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

## 9 role field relation
CREATE TABLE  if not exists `role_vo_field` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `field_no` int(11) NOT NULL COMMENT '字段编号',
  `role_no` int(11) NOT NULL COMMENT '角色编号',
  `is_enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可以访问',
    `gmt_create` datetime COMMENT '表创建时间',
  `gmt_modified` datetime COMMENT '表修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;

