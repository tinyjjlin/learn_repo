

##
alter table role_permission_relation add constraint PK_role_permission primary key(role_no,permission_no);

alter table staff_role_relation add constraint PK_staff_role primary key(emp_no,role_no);

## 插入更新
insert into role_permission_relation
(role_no,permission_no)
values(100,100)
on duplicate key update permission_no = 102;

##插入更新
insert into role_permission_relation
(role_no,permission_no)
values(100,111),(200,111),(300,3242)
on duplicate key update permission_no = values(permission_no);