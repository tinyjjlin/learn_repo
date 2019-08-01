#learn ubuntu
##1. ubuntu server
rember info: ``login:jjlin, passwd:linlin00``

###1.1. ubuntu server安装的时候要你新建一个用户，安装完成后，你需要手动开启root。
 ``sudo passwd root``  login:root ,passwd:root
###1.2 软件下载
``sudo apt-get  install [soft]``
###1.3查看系统版本
``sudo lsb_relase -a``
###1.4 查看系统内核
`` sudo uname -a``

查看系统多少位

``sudo uname --m``
###1.5 安装ssh 服务
``sudo apt-get install openssh-server``


查看ssh服务是否启动

``sudo ps -e | grep ssh``

启动ssh服务

``sudo service ssh start``

