`/etc/nginx/sites-available` 存放所有站点配置文件(server)

~~~shell
server {
    listen 8066;
    server_name 172.18.19.3;
    #charset utf-8;
    location /api/{
    	proxy_pass http://172.18.19.3:8082/api/;
    }
    location ~ .*\.(gif|jpg|jpeg|png)$ {
    	root /usr/project/images/;
    	autoindex on;
    }
    location /{
    	root  /usr/project/brs_oa_release/web/brs-oa-web-1.4.030719-beta/dist;
    	index  index.html  index.htm;
    	expires 7d;
    }

}

~~~



`/etc/nginx/sites-enabled`  存放启用站点的软连接 

与sites-available文件夹里的配置文件建立软连接

![1551951836203](C:\Users\h100067\Desktop\nginx多站点配置\assets\1551951836203.png)

~~~sh
ln -s /etc/nginx/sites-available/brs_oa.conf /etc/nginx/sites-enabled/brs_oa
~~~

也可以在`/etc/nginx/sites-enabled`直接与git仓库内的nginx配置文件进行软连接



最终nginx会引入/etc/nginx/sites-enabled里的软连接文件然后启动web服务





## 配置流程

直接与git仓库的配置文件链接

1. git pull获取最新项目文件

2. 删除旧的软连接 

   `rm -f /etc/nginx/sites-enabled/brs_oa`

3. 将nginx配置文件与/etc/nginx/sites-enabled内的brs_oa.conf建立软连接

   `ln -s /usr/project/brs_oa_release/configure/brs_oa.conf /etc/nginx/sites-enabled/brs_oa`

4. 重启nginx服务

   `service nginx restart`

