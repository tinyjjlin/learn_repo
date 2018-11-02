# mongoDB 使用

##1. mongoDB安装

  安装时应注意的重点：

1. cmd要获取管理员权限。

[cmd.exe](  C:\Windows\WinSxS\wow64_microsoft-windows-commandprompt_31bf3856ad364e35_10.0.10586.0_none_21e70967f9147e9b)

2. 配置安装mongo服务器

  有几种方式：
1.命令行安装；2通过配置文件（存在问题）安装
```
mongod --logpath "D:\data\log\MongoDB.log" --logappend --dbpath "D:\data\db" --directoryperdb --serviceName "MongoDB" --serviceDisplayName "MongoDB" --install


mongod --config "F:\MongoDB\Server\mongod.cfg" --directoryperdb --serviceName "MongoDB" --serviceDisplayName "MongoDB" --install
```

##3. 启动服务器（cmd获取管理员权限）
```
    net start mongodb
    net stop mongodb
```
##4 使用

[参考](https://www.cnblogs.com/wkrbky/p/6352188.html)
