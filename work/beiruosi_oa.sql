# db beiruosi_oa
create database beiruosi_oa  character  SET utf8 collate  utf8_general_ci;

#company
create table if not exists  brs_company(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#department 
create table if not exists brs_department(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
    primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#user
create table if not exists brs_user(
  id int unsigned auto_increment not null,
  uid varchar(10) not null,
  name varchar(30) not null,
  pwd varchar(50) not null,
  dept_code varchar(10),
    primary key(id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#position
create table if not exists brs_position(
   id int unsigned auto_increment not null,
   code varchar(10) not null,
   name varchar(20) not null,
   description varchar(50) not null,
   parent_position varchar(10) ,
   dept_code varchar(10),
     primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#role
create table if not exists role(
   id int unsigned auto_increment,
   code  varchar(5) not null,
   name varchar(10) not null,
   description varchar(50) ,
   avaliable tinyint  DEFAULT 1,
   primary key(id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# user_role
create table if not exists user_role(
  id int unsigned auto_increment,
  user_id int unsigned ,
  role_id int unsigned,
  primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#permission
create table if not exists permission(
  id int unsigned auto_increment not null,
  code  varchar(5) not null,
  name varchar(10) not null,
  resource_type varchar(10) DEFAULT "menu",
  url varchar(100) ,
  parent_id int unsigned,
  parent_ids varchar(10),
  permission varchar(30),
  avaliable tinyint DEFAULT 1,
  primary key(id)
 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# role_permission
create table if not exists role_permission(
   id int unsigned auto_increment not null,
   role_id int unsigned,
   permission_id int  unsigned,
   primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


# insert 
insert into role_permission(role_id,permission_id)values(1,2),(1,3);



# drop table
drop table permission;

#insert 

# user manager module
insert into permission (id,code,name,resource_type,url,parent_id,parent_ids,permission)values(
1,
"01",
"用户管理",
"menu",
"user/view",
0,
"0/",
"user:view"
);
# add user 
insert into permission (id,code,name,resource_type,url,parent_id,parent_ids,permission)values(
2,
"02",
"添加用户",
"button",
"user/add",
1,
"0/2",
"user:add"
);

# delete user 
insert into permission (id,code,name,resource_type,url,parent_id,parent_ids,permission)values(
3,
"03",
"删除用户",
"button",
"user/delete",
1,
"0/3",
"user:delete"
);







#module
create table if not exists brs_module(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
  parent_module varchar(20) ,
  description varchar(50),
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

#action
create table if not exists brs_action(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  name varchar(20) not null,
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET =utf8;

# permission
create table if not exists brs_permission(
  id int unsigned auto_increment not null,
  code varchar(10) not null,
  module_code varchar(10) not null,
  action_code varchar(10) not null,
  value varchar(20),
  primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET =utf8;

# foreign key 
foreign key(parent_id ) references parent(id) on delete cascade

# add foreign key
add constraint foreignkeyname foreign key(id) references tabl_name(id)
on delete{restrict|cascade |set null|no action }
on update {}

# 查找指定用户对应的角色
select A.id,A.code,A.name,A.avaliable from brs_role as A
left join
brs_user_role as B on A.id= B.role_id
left join
brs_user as C on C.id= B.user_id
where C.name ="纪俊林"
#插入角色
insert into role(code,name,description)values("02","IT部门经理","IT部门经理")

#将用户指定角色
insert into role_permission(role_id,permission_id)values
  (3,1),(3,2),(3,3);

#根据指定角色查询对应拥有的权限
select permission.id,permission.code,permission.name,permission.resource_type,permission.url,permission.parent_id,permission.parent_ids,permission.permission,permission.avaliable 
from permission
left join role_permission
on permission.id = role_permission.permission_id
left join role
on role.id = role_permission.role_id
where role.code ="01"

#根据部门编号获取员工信息,指定部门员工信息
select brs_user.id,brs_user.uid,brs_user.name,brs_department.name from brs_user
left join  brs_department
on brs_user.dept_code = brs_department.code
where brs_department.code="01";


#根据指定用户查询对应拥有的权限
"select P.id,P.code,P.name\n" +
            "from brs_permission as P\n" +
            "left join brs_role_permission as RP\n" +
            "on P.id = RP.permi_id\n" +
            "left join brs_role as R\n" +
            "on R.id = RP.role_id\n" +
            "where R.code =#{roleCode}"


select  P.id,P.code,P.name,P.type,P.parent_code,P.parent_ids,P.url,P.pre_code from brs_permission as P 
left join brs_role_permission as RP
on P.id = RP.permi_id
left join brs_role as R
on R.id = RP.role_id
left join brs_user_role as UR
on UR.role_id = R.id
left join brs_user as U
on U.id = UR.user_id
where U.uid =100057;


select br.field_name,br.field_desc,br.from_dto,brf.accessable from brs_field as bf
left join  brs_role_field as brf
on bf.id = brf.field_id
left join brs_role as br
on br.id = brf.role_id
left join brs_user_role as bur
on br.id = bur.role_id
left join brs_user as bu
on bu.id = bur.user_id
where bu.code ="j100057" and bf.from_dto ="UserDTO";