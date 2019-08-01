# ubuntu

# 常用命令
```
#查看安装的软件
dpkg -l | grep ftp

#查看版本
cat /etc/issue
sudo lsb_release -a

apt-get install default-jre

#寻找安装文件
whereis nignx
find / -name nginx
```
## install java 设置JAVA_HOME环境变量
```
/ etc / environment
JAVA_HOME="/usr/lib/jvm/java-8-oracle"
保存并退出文件，然后重新加载。

source /etc/environment
现在可以通过执行以下命令来测试是否已设置环境变量：

echo $JAVA_HOME
```

# 系统：Ubuntu16.04
常用的软件安装方式有两种：

第一种：apt-get（安装后略类似于windows中的安装版软件）：

例：apt-get install ssh

1.下载的软件存放位置

/var/cache/apt/archives
2.安装后软件默认位置
/usr/share
3.可执行文件位置 
/usr/bin
4.配置文件位置
/etc
5.lib文件位置
/usr/lib 

第二种：手动下载软件安装包（安装后略类似于绿色版软件）：

好处：看着干净（个人觉得）

坏处：版本对应与依赖问题，要搞清楚需要多少依赖包。。。。

今天手动下载的rabbitmq，用的系统默认的源，结果版本不兼容，参考了下面的博客安装成功：

 Ubuntu软件安装与删除相关命令 

安装软件

命令： apt-get install softname1 softname2 softname3……

卸载软件

命令： apt-get remove softname1 softname2 softname3……

卸载并清除配置

命令： apt-get remove --purge softname1

更新软件信息数据库

命令： apt-get update

进行系统升级

命令： apt-get upgrade

搜索软件包

命令： apt-cache search softname1 softname2 softname3……

Deb软件包相关安装与卸载

安装deb软件包

命令： dpkg -i xxx.deb

删除软件包

命令： dpkg -r xxx.deb

连同配置文件一起删除

命令： dpkg -r --purge xxx.deb

查看软件包信息

命令： dpkg -info xxx.deb

查看文件拷贝详情

命令： dpkg -L xxx.deb

查看系统中已安装软件包信息

命令： dpkg -l

重新配置软件包

命令： dpkg-reconfigure xxx

解决依赖关系

命令：

sudo apt-get update(更新源)

sudo apt-get -f install


# ubuntu

# 常用命令
```
#查看安装的软件
dpkg -l | grep ftp

#查看版本
cat /etc/issue
sudo lsb_release -a

apt-get install default-jre
```
## install java 设置JAVA_HOME环境变量
```
/ etc / environment
JAVA_HOME="/usr/lib/jvm/java-8-oracle"
保存并退出文件，然后重新加载。

source /etc/environment
现在可以通过执行以下命令来测试是否已设置环境变量：

echo $JAVA_HOME
```

# 系统：Ubuntu16.04
常用的软件安装方式有两种：

第一种：apt-get（安装后略类似于windows中的安装版软件）：

例：apt-get install ssh

1.下载的软件存放位置

/var/cache/apt/archives
2.安装后软件默认位置
/usr/share
3.可执行文件位置 
/usr/bin
4.配置文件位置
/etc
5.lib文件位置
/usr/lib 

第二种：手动下载软件安装包（安装后略类似于绿色版软件）：

好处：看着干净（个人觉得）

坏处：版本对应与依赖问题，要搞清楚需要多少依赖包。。。。

今天手动下载的rabbitmq，用的系统默认的源，结果版本不兼容，参考了下面的博客安装成功：


#1. vwmare虚拟机的使用，配置
#2. ubuntu常见操作
1.打开终端方式
CTRL+ALT+T
2.配置网络

//切换用户
su root

//sudo
#3. 问题解决
##1.vmware 中联网，采用NAT
什么是NAT？

配置步骤：

```
//1.VMware的编辑->虚拟网络编辑器重新建立ＮＡＴ网络
//2.确认VMware service 三个服务开启
//3.vmnet8以太网采用自动获取ip，dns
```
ubuntu中eth0 配置ip
```

```