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