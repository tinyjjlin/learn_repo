#mysql使用
##1. mysql 8 安装
重要部分
###1. 添加配置文件my.ini

```
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=D:\\Program Files\MySQL\\mysql-8.0.12-winx64
# 设置mysql数据库的数据的存放目录
datadir=F:\database\mysql\data
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。这是为了防止有人从该主机试图攻击数据库系统
max_connect_errors=10
# 服务端使用的字符集默认为UTF8
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8
```

###2. 初始化数据库
```
mysqld --initialize --console
```
###3.安装服务
```
mysqld --install [mysql8]
```
###4.启动服务
```
net start mysql8
```
###5. 更改密码
```
mysql -u root -p
```
密码为安装时设置的密码：root(在安装时设置的密码)

如果安装时没有设置密码，则在数据库初始化时，生成的随机密码即为第一次登录的密码。

说明：
```
SET PASSWORD=PASSWORD('[修改的密码]');
就可以更改密码，但是MySQL8.0.4开始，这样默认是不行的。因为之前，MySQL的密码认证插件是“mysql_native_password”，而现在使用的是“caching_sha2_password”。

　　因为当前有很多数据库工具和链接包都不支持“caching_sha2_password”，为了方便，我暂时还是改回了“mysql_native_password”认证插件。

修改用户密码，在MySQL中执行命令：

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '新密码';
修改密码验证插件，同时修改密码。

　　如果想默认使用“mysql_native_password”插件认证，可以在配置文件中配置default_authentication_plugin项。

[mysqld]
default_authentication_plugin=mysql_native_password
```


