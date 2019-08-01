# linux 学习笔记

---

## 1 进程
### 1 ps
```
ps
-A：显示所有进程
a：显示终端中包括其它用户的所有进程
x：显示无控制终端的进程
u: 代表用户
```
### 2 任务：top命令

top命令提供了运行中系统的动态实时视图。

### 3 任务：显示进程的树状图。
pstree以树状显示正在运行的进程。树的根节点为pid或init。如果指定了用户名，进程树将以用户所拥有的进程作为根节点。

### 4 任务：查找进程
 
使用pgrep命令。pgrep能查找当前正在运行的进程并列出符合条件的进程ID。例如显示firefox的进程ID：

### 5 atop工具

atop是一个用来查看Linux系统负载的交互式监控工具。它能展现系统层级的关键硬件资源(从性能角度)的使用情况，如CPU、内存、硬盘和网络。

它也可以根据进程层级的CPU和内存负载显示哪个进程造成了特定的负载;如果已经安装内核补丁可以显示每个进程的硬盘和网络负载。

## killall kill pkill
killall 命令

　　Linux系统中的killall命令用于杀死指定名字的进程（kill processes by name）。我们可以使用kill命令杀死指定进程PID的进程，如果要找到我们需要杀死的进程，我们还需要在之前使用ps等命令再配合grep来查找进程，而killall把这两个过程合二为一，是一个很好用的命令。

　　1.命令格式

　　　　killall[参数][进程名]

 

　　2.命令参数

-Z 只杀死拥有scontext 的进程
-e 要求匹配进程名称
-I 忽略小写
-g 杀死进程组而不是进程
-i 交互模式，杀死进程前先询问用户
-l 列出所有的已知信号名称
-q 不输出警告信息
-s 发送指定的信号
-v 报告信号是否成功发送
-w 等待进程死亡
--help 显示帮助信息
--version 显示版本显示

1：杀死所有同名进程
    killall nginx
    killall -9 bash

2.向进程发送指定信号
    killall -TERM ngixn  或者  killall -KILL nginx

## nohup

 在生产环境下启动Weblogic时，发现原来好好的nohup信息输出到指定文件中的功能，突然出问题了。现象是控制台输出的信息一部分输出到了我指定的文件，另一部分却输出到了nohup.out，而我是不想让它产生nohup.out文件，不知道是什么原因。

我的启动命令是这样的：
nohup bin/startManagedServer.sh myserver htp://192.168.0.1 -Xms2048m -Xmx2048m > logs/myserver.out &现在指行这个命令，会给我产生两个文件，一个中logs/myserver.out，另一个是nohup.out文件。
怎样才能让它不产生nohup.out文件呢。
网上搜了半天，据说好象可以把后面的 “&” 改成 “2>&1 &”，于是把启动命令改成如下：

nohup bin/startManagedServer.sh myserver htp://192.168.0.1 -Xms2048m -Xmx2048m > logs/myserver.out 2>&1 &再次执行，问题解决。

解释如下：

2>
表示把标准错误(stderr)重定向，标准输出(stdout)是1。

尖括号后面可以跟文件名，或者是&1, &2，分别表示重定向到标准输出和标准错误。

2> &1
1> &2
2> stderr.log
1> stdout.log 


### 常用命令
```
whereis 
#新建文件
touch [filename]
# 新建文件夹
mkdir dir
#删除文件，文件夹，内部不为空


```


rm [选项] 文件

选项说明：

-f　　　　-force　　　　　　忽略不存在的文件，强制删除，无任何提示

-i　　　　--interactive　　　 进行交互式地删除

-r | -R　　--recursive　　　  递归式地删除列出的目录下的所有目录和文件

-v　　　   --verbose　　　　详细显示进行的步骤