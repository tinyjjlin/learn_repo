#mysql

```
#create database
create database |schema if not exists db_name

default character set utf8
default collate uti8_general_ci
alter database tiny_news default character set utf8;

#create table 

create table if not exists news_brief(
    nb_id int unsigned auto_increment not null,
    nb_title varchar(50) not null,
    nb_from varchar(50),
    nb_refresh_time timestamp,
    nb_plot_url varchar(100),
    nb_detail int ,
    nb_type int,
    nb_category int,
    primary key(nb_id)
  )engine=innodb default charset=utf8;

create table if not exists news_detail(
    nd_id int unsigned auto_increment not null,
    nd_content text not null,
    primary key(nd_id)
  )engine=innodb default charset=utf8;
#查看表结构，表创建sql
desc table_name;
show create table table_name;
#设置外键
FOREIGN KEY(c_id) REFERENCES t_class(id)
alter table news_brief add constraint detail_foreign_key foreign key(nb_detail) references news_detail(nd_id);
#删除外键
alter table drop foreign key 外键名;   
#修改列
alter table news_brief modify nb_detail int(10);
alter table test rename test1; --修改表名  

 # 列重命名
 alter table news_brief change nb_detail detail_id int(10) unsigned;

alter table test add  column name varchar(10); --添加表列   
alter table test drop  column name; --删除表列  
alter table test modify address char(10) --修改表列类型  
||alter table test change address address  char(40) 

#查看约束
show index from news_brief;
```















##1 mysql 用户设置
```
use mysql;
INSERT INTO user
          (host, user, password,
           select_priv, insert_priv, update_priv)
           VALUES ('localhost', 'guest',
           PASSWORD('guest123'), 'Y', 'Y', 'Y');

FLUSH PRIVILEGES;

Select_priv
Insert_priv
Update_priv
Delete_priv
Create_priv
Drop_priv
Reload_priv
Shutdown_priv

Process_priv
File_priv
Grant_priv
References_priv
Index_priv
Alter_priv
```
##2 mysql 管理
1. use databaseName;
2. show database;
3. show tables;
4. show columns from [tablename];
5. show index from [tablename];
6.exit  contrl+c

## 3 创建删除数据库
```
//1
mysql -u root -p
create database  [dbname];
//2
mysqladmin -u root -p create RUNOOB

drop database [dbname];
mysqladmin -u root -p drop RUNOOB
```
## 4 数据类型
1. 日期：data，time，year，datetime，timestampzifc
2. 字符串：char,varchar,tinyblog,blog,tinytext,text,

##5 创建，删除，修改，表
```
//1
create table [tablename](
    [columnname] [column_type]
    )engine=innodb default charset=utf8;

    CREATE TABLE IF NOT EXISTS `runoob_tbl`(
   `runoob_id` INT UNSIGNED AUTO_INCREMENT,
   `runoob_title` VARCHAR(100) NOT NULL,
   `runoob_author` VARCHAR(40) NOT NULL,
   `submission_date` DATE,
   PRIMARY KEY ( `runoob_id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
//2
drop table [tablename];
//3修改报名，修改列名，添加列，添加属性约束，主键，外键，约束。
```


表列的约束：

1. unsigned
2. auto_increment
3. not null,null
4. primary key
5. foreign key

## 6 插入数据
```
INSERT INTO table_name ( field1, field2,...fieldN )
                       VALUES
                       ( value1, value2,...valueN );
```
##7 查询数据
```
SELECT column_name,column_name
FROM table_name
[WHERE Clause]
[LIMIT N][ OFFSET M]

```

##8 分组 group by
```
//显示分组中为空值项
with rollup
SELECT name, SUM(singin) as singin_count FROM  employee_tbl GROUP BY name WITH ROLLUP;
//当列中空值用指定值代替
select coalesce(a,b,c);
SELECT coalesce(name, '总数'), SUM(singin) as singin_count FROM  employee_tbl GROUP BY name WITH ROLLUP
```
##9 空值处理
在 MySQL 中，NULL 值与任何其它值的比较（即使是 NULL）永远返回 false，即 NULL = NULL 返回false 。
MySQL 中处理 NULL 使用 IS NULL 和 IS NOT NULL 运算符。
```
IS NULL   IS NOT NULL

```

ifnull(column2,0)

##10正则表达式

##11 事务
原子性A

一致性：

永久性：

begin rollback commit

##12 索引
单列索引，组合索引

普通索引
创建索引
这是最基本的索引，它没有任何限制。它有以下几种创建方式：

CREATE INDEX indexName ON mytable(username(length));
如果是CHAR，VARCHAR类型，length可以小于字段实际长度；如果是BLOB和TEXT类型，必须指定 length。

修改表结构(添加索引)
ALTER table tableName ADD INDEX indexName(columnName)
创建表的时候直接指定
CREATE TABLE mytable(

ID INT NOT NULL,

username VARCHAR(16) NOT NULL,

INDEX [indexName] (username(length))

);
删除索引的语法
DROP INDEX [indexName] ON mytable;
唯一索引
它与前面的普通索引类似，不同的就是：索引列的值必须唯一，但允许有空值。如果是组合索引，则列值的组合必须唯一。它有以下几种创建方式：

创建索引
CREATE UNIQUE INDEX indexName ON mytable(username(length))
修改表结构
ALTER table mytable ADD UNIQUE [indexName] (username(length))
创建表的时候直接指定
CREATE TABLE mytable(

ID INT NOT NULL,

username VARCHAR(16) NOT NULL,

UNIQUE [indexName] (username(length))

);
使用ALTER 命令添加和删除索引
有四种方式来添加数据表的索引：

ALTER TABLE tbl_name ADD PRIMARY KEY (column_list): 该语句添加一个主键，这意味着索引值必须是唯一的，且不能为NULL。
ALTER TABLE tbl_name ADD UNIQUE index_name (column_list): 这条语句创建索引的值必须是唯一的（除了NULL外，NULL可能会出现多次）。
ALTER TABLE tbl_name ADD INDEX index_name (column_list): 添加普通索引，索引值可出现多次。
ALTER TABLE tbl_name ADD FULLTEXT index_name (column_list):该语句指定了索引为 FULLTEXT ，用于全文索引。

##13元数据
命令  描述
SELECT VERSION( )   服务器版本信息
SELECT DATABASE( )  当前数据库名 (或者返回空)
SELECT USER( )  当前用户名
SHOW STATUS 服务器状态
SHOW VARIABLES  服务器配置变量

##14 MySQL 处理重复数据

##15数据库优化

https://www.cnblogs.com/wangning528/p/6388538.html

https://www.cnblogs.com/zhanglei93/p/6696599.html

https://blog.csdn.net/py_xin/article/details/51593127

explain
查询的开销指标

执行时间， 检查的行数，返回的行数

1建立索引

索引加快查询速度（索引的原理，b+tree hash)
myISam
innodb,支持事务，并发性高，支持行锁。

2 count优化

```
 select count(*) from world.city where id > 5; b. select (select count(*) from world.city) – count(*) from world.city where id <= 5

 ```

 尽量不使用通配符*

 3 避免使用不兼容的数据类型。
 4 不用再索引字段上进行运算会使索引失效。

尽量避免在WHERE子句中对字段进行函数或表达式操作，这将导致引擎放弃使用索引而进行全表扫描。如： SELECT * FROM T1 WHERE F1/2=100 应改为: SELECT * FROM T1 WHERE F1=100*2

5避免使用!=或＜＞、IS NULL或IS NOT NULL、IN ，NOT IN等这样的操作符.
6. 尽量使用数字型字段.
7 合理使用EXISTS,NOT EXISTS子句
8能够用BETWEEN的就不要用IN
9能够用DISTINCT的就不用GROUP BY
10尽量不要用SELECT INTO语句。SELECT INTO 语句会导致表锁定，阻止其他用户访问该表。
11必要时强制查询优化器使用某个索引
12尽量避免在索引过的字符数据中，使用非打头字母搜索。这也使得引擎无法利用索引
13 limit 优化，采用覆盖查询inner join


使用b tree
索引中包含列，所以查询有索引的列时，可以不用查询表。
而hash索引，节点包含的是行指针，所以要扫描行数据据。
不支持排序，hash key不是顺序存的
不支持部分列的匹配，按照列的全名进行的
不支持范围查找，
explain extend

