use brs_oa;
# create user;
CREATE TABLE `brs_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `pwd` varchar(50) CHARACTER SET utf8 NOT NULL,
  `dept_no` int(11) DEFAULT NULL,
  `emp_no` int(11) NOT NULL,
  `login_id` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `nation` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `politics_status` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `highest_degree` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `marital_status` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `mobile` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `current_address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `identity_card` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `position` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

#department
CREATE TABLE `brs_department` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_no` int(11) NOT NULL,
  `dept_name` varchar(20) NOT NULL,
  `parent_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# education exp
CREATE TABLE `brs_education_exp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shcool_name` varchar(45) DEFAULT NULL,
  `period_time` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `diplomas` varchar(45) DEFAULT NULL,
  `user_emp_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#role
CREATE TABLE `brs_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_no` int,
  `description` varchar(50) DEFAULT NULL,
  `avaliable` tinyint(4) DEFAULT '1',
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# user_role

CREATE TABLE `brs_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_emp_no` int NOT NULL,
  `role_no` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



# permission
CREATE TABLE `brs_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `permi_no` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `parent_no` varchar(20) DEFAULT NULL,
  `parent_nos` varchar(45) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `permi_code` varchar(100) DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;


# role permission

CREATE TABLE `brs_role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_no` int(11) NOT NULL,
  `permi_no` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;






# 工资

CREATE TABLE `brs_salary_monthly_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_emp_no` int(11) NOT NULL COMMENT '工号',
  `settlement_day` date NOT NULL COMMENT '日期',
  `basic_salary` decimal(10,2) NOT NULL COMMENT '基本工资',
  `bonus_salary` decimal(10,2) NOT NULL COMMENT '浮动工资',
  `commission` decimal(10,2) NOT NULL COMMENT '提成',
  `deduction` decimal(10,2) NOT NULL COMMENT '事假扣除',
  `payment` decimal(10,2) NOT NULL COMMENT '个人税前工资',
  `social_insurance_of_staff` decimal(10,2) NOT NULL COMMENT '个人缴纳社保',
  `tax_of_staff` decimal(10,2) NOT NULL COMMENT '个人所得税',
  `payment_in_hand` decimal(10,2) NOT NULL COMMENT '个人税后工资(到手)',
  `social_insurance_of_company` decimal(10,2) NOT NULL COMMENT '公司缴纳社保',
  `expenditure` decimal(10,2) NOT NULL COMMENT '公司支出合计',
  `description` varchar(1200) NOT NULL COMMENT '补充说明'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4


select bp.permi_no,bp.name,bp.type,bp.parent_no,bp.parent_nos,bp.url,bp.permi_code,bp.available from brs_permission as bp 
left join brs_role_permission as brp 
on brp.permi_no = bp.permi_no
left join brs_role as br
on brp.role_no = br.role_no
left join brs_user_role as bur 
on bur.role_no = br.role_no
where bur.user_emp_no =100057;
