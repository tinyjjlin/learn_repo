# mysql 数据库命名规范

----
1. 数据库名：英文小写

2. 表名 都小写  前缀为模块名称缩写 t

eg: t_user  t_role  t_permission

3. 字段（列名） 英文小写字母且都用单数，多个英文用下划线连接

id 主键 bigint unsigned auto_increment 

tablename_id 表示外键名 (在单机，不考虑分布式下)

所有字段，都指定默认值

时间字段可以考虑使用int类型

4. 具体字段命名规则



