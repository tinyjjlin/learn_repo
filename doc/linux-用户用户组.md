# linux 用户，用户组管理

参考：

1. [linux用户，用户组管理](https://www.cnblogs.com/clicli/p/5943788.html)
2. [查看用户组](https://www.cnblogs.com/xiohao/p/5877256.html)

## 1 用户账户管理
1. `useradd`
2. `userdel`
3. `usermod`

```
使用说明
useradd 选项 用户名
其中各选项含义如下：
代码:
-c comment 指定一段注释性描述。
-d 目录 指定用户主目录，如果此目录不存在，则同时使用-m选项，可以创建主目录。
-g 用户组 指定用户所属的用户组。
-G 用户组，用户组 指定用户所属的附加组。
-s Shell文件 指定用户的登录Shell。
-u 用户号 指定用户的用户号，如果同时有-o选项，则可以重复使用其他用户的标识号。
用户名 指定新账号的登录名。

# useradd -s /bin/sh -g group –G adm,root gem
此命令新建了一个用户gem，该用户的登录Shell是/bin/sh，它属于group用户组，同时又属于adm和root用户组，其中group用户组是其主组。
## 1 用户组 group
```


1. `groupad`
2. `groupdel`
3. `groupmod`

## demo
 1. 用户组重命名

`groupmod -n newgroupname oldgroupname`

2 用户缺换用户组

`newgrp root`


## 更改所有者所属组chown(change own)
命令语法

chown -R 账户名 文件名
chown -R 账户名：组名 文件名

## chgrp(change group)
chgrp 组名 文件名