# create db brs_oa;
create database brs_oa  character  SET utf8 collate  utf8_general_ci;
use brs_oa;
#user
CREATE TABLE `brs_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `usercode` varchar(32) NOT NULL COMMENT '账号',
  `username` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# role
CREATE TABLE `brs_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#user_role
CREATE TABLE `brs_user_role` (
  `id` varchar(36) NOT NULL,
  `brs_user_id` varchar(32) NOT NULL,
  `brs_role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# permission

CREATE TABLE `brs_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# role_permission
CREATE TABLE `brs_role_permission` (
  `id` varchar(36) NOT NULL,
  `brs_role_id` varchar(32) NOT NULL COMMENT '角色id',
  `brs_permission_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# permission info
insert  into `brs_permission`(`id`,`name`,`type`,`url`,`percode`,`parentid`,`parentids`,`sortstring`,`available`) values 
(1,'权限','','',NULL,0,'0/','0','1'),(11,'商品管理','menu','/item/queryItem.action',NULL,1,'0/1/','1.','1'),
(12,'商品新增','permission','/item/add.action','item:create',11,'0/1/11/','','1'),
(13,'商品修改','permission','/item/editItem.action','item:update',11,'0/1/11/','','1'),
(14,'商品删除','permission','','item:delete',11,'0/1/11/','','1'),
(15,'商品查询','permission','/item/queryItem.action','item:query',11,'0/1/15/',NULL,'1'),
(21,'用户管理','menu','/user/query.action','user:query',1,'0/1/','2.','1'),
(22,'用户新增','permission','','user:create',21,'0/1/21/','','1'),
(23,'用户修改','permission','','user:update',21,'0/1/21/','','1'),
(24,'用户删除','permission','','user:delete',21,'0/1/21/','','1');

#role info

insert  into `brs_role`(`id`,`name`,`available`) values 
	('ebc8a441-c6f9-11e4-b137-0adc305c3f28','商品管理员','1'),
	('ebc9d647-c6f9-11e4-b137-0adc305c3f28','用户管理员','1');

# user info
 
insert  into `brs_user`(`id`,`usercode`,`username`,`password`,`salt`,`locked`) values 
	('lisi','lisi','李四','bf07fd8bbc73b6f70b8319f2ebb87483','uiwueylm','0'),
	('zhangsan','zhangsan','张三','cb571f7bd7a6f73ab004a70322b963d5','eteokues','0');


insert  into `brs_user_role`(`id`,`brs_user_id`,`brs_role_id`) values 
	('ebc8a441-c6f9-11e4-b137-0adc305c3f28','zhangsan','ebc8a441-c6f9-11e4-b137-0adc305c'),
	('ebc9d647-c6f9-11e4-b137-0adc305c3f28','lisi','ebc9d647-c6f9-11e4-b137-0adc305c');



insert  into `brs_role_permission`(`id`,`brs_role_id`,`brs_permission_id`) values 
	('ebc8a441-c6f9-11e4-b137-0adc305c3f21','ebc8a441-c6f9-11e4-b137-0adc305c','12'),
	('ebc8a441-c6f9-11e4-b137-0adc305c3f22','ebc8a441-c6f9-11e4-b137-0adc305c','11'),
	('ebc8a441-c6f9-11e4-b137-0adc305c3f24','ebc9d647-c6f9-11e4-b137-0adc305c','21'),
	('ebc8a441-c6f9-11e4-b137-0adc305c3f25','ebc8a441-c6f9-11e4-b137-0adc305c','15'),
	('ebc9d647-c6f9-11e4-b137-0adc305c3f23','ebc9d647-c6f9-11e4-b137-0adc305c','22'),
	('ebc9d647-c6f9-11e4-b137-0adc305c3f26','ebc8a441-c6f9-11e4-b137-0adc305c','13');
 