# mysql 创建新的用户

reference: [创建新的用户](https://blog.csdn.net/qq_37392589/article/details/81487144)

```
mysql -u root -p

create user 'flowable'@'%' identified by 'flowable'

# 为数据库
grant all privileges on flowaleDb.* to 'flowable'@'%'；

# 查看所有权限
show grants for 'flowable'@'%'

#取消权限
取消来自远程服务器的mjj用户对数据库db1的所有表的所有权限
revoke all on  flowableDb.* to 'flowable'@'%' 

取消来自远程服务器的mjj用户所有数据库的所有的表的权限
revoke all privileges on '*' from 'mjj'@'%';
```

# mysql 备份

```
# 备份：数据表结构+数据
mysqdump -u root db1 > db1.sql -p


# 备份：数据表结构
mysqdump -u root -d db1 > db1.sql -p

#导入现有的数据到某个数据库
#1.先创建一个新的数据库
create database db10;
# 2.将已有的数据库文件导入到db10数据库中
mysqdump -u root -d db10 < db1.sql -p

```