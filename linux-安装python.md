# Linux 安装python

## install pip3
```
apt install python3-pip
```

## Linux  pip使用国内镜像
清华大学：https://pypi.tuna.tsinghua.edu.cn/simple

阿里云：https://mirrors.aliyun.com/pypi/simple

中国科学技术大学 https://pypi.mirrors.ustc.edu.cn/simple

豆瓣：http://pypi.douban.com/simple

```
cd ~ && mkdir .pip
cd .pip && vim pip.conf
~/.pip/pip.conf
[global]
index-url = https://pypi.tuna.tsinghua.edu.cn/simple
[install]
trusted-host = https://pypi.tuna.tsinghua.edu.cn
```

## pipenv 使用说明