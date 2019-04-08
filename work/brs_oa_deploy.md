# brs oa deploy

---
## ubuntu 环境安装
1.  java 
2.  nginx
3.  redis 
4.  supervisor
```
apt-get install java(openJDK)
apt-get install nginx
apt-get install redis
apt-get install supervisor 
```

## 部署准备

brs oa系统打包后存放的仓库为[brs_oa_release](http://172.18.19.2:3000/j100057/brs_oa_release.git
)

地址：http://172.18.19.2:3000/j100057/brs_oa_release.git

其中服务放在api目录下，前端页面放在web目录下。

将最新版本的服务拷贝到 /usr/project 目录下；将最新版本的前端页面拷贝到/usr/project/web目录下。
```
cp /usr/project/brs_oa_release/api/v.xx(版本号)/oa.xx.jar  /usr/project/oa.jar

cd /usr/project
mkdir web
cp /usr/project/brs_oa_release/web/v.xx(版本号)/dist/* -r /usr/project/web/
```

## 配置

### 1 nginx 配置
```
#查看nginx 安装路径

whereis nginx

#打开nginx 配置文件

vim /etc/nginx/nginx.conf

# 添加服务

  server {
              listen 8066;
              server_name 172.18.19.3;
              #charset utf-8;
              location /api/{
                    proxy_pass http://172.18.19.3:8082;
               }
               location /images/{
                    root /usr/project/;
                    autoindex on;
               }
               location /{
                    root  /usr/project/web;
                    index  index.html  index.htm;
                    expires 7d;
                }

         }

#nginx 启动
nginx

#修改配置文件重起nginx
nginx -s reload
```

### 2 supervisor配置
```
#添加supervisor管理的服务

# 进入conf.d目录下
cd /etc/supervisor/conf.d

#新建文件brs-oa-api.conf
vim brs-oa-api.conf

#添加内容
[program:brs-oa-api]
command= java -jar /usr/project/oa.jar
directory=/usr/project
autostart=true
autorestart=true

#修改服务配置文件后需重新启动
supervisorctl status
supervisorctl stop brs-oa-api
supervisorctl start brs-oa-api
```



