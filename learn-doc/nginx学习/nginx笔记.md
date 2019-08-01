# nginx 学习笔记

---
## 常用命令
```
nginx -s stop
nginx -s quit
nginx -s reload
nginx -s reopen
nginx -c filename
nginx -t
nginx -v
start nginx
```

## 配置文件详解
参考：[nginx配置优化](https://www.cnblogs.com/zhang-shijie/p/5428640.html)

```
log_format logstash_json '{"@timestamp":"$time_iso8601",'
        '"host":"$server_addr",'
        '"clientip":"$remote_addr",'
        '"size":$body_bytes_sent,'
        '"responsetime":$request_time,'
        '"upstreamtime":"$upstream_response_time",'
        '"upstreamhost":"$upstream_addr",'
        '"http_host":"$host",'
        '"url":"$uri",'
        '"domain":"$host",'
        '"xff":"$http_x_forwarded_for",'
        '"referer":"$http_referer",'
        '"agent":"$http_user_agent",'
        '"status":"$status"}';
server {
　　　　listen 8090;
　　　　server_name samsung.chinacloudapp.cn;
　　　　access_log /var/log/nginx/samsung1.access.log logstash_json;
　　　　location / {
　　　　　　root html;
　　　　　　index index1.html index.htm;
　　　　}
　　　　error_page 500 502 503 504 /50x.html;
　　　　location = /50x.html {
　　　　root html;
　　　　　}
　　}

    access_log  /var/log/nginx/json.access.log  logstash_json;  #定义日志路径为/var/log/nginx/json.access.log,并引用在主配置文件nginx.conf中定义的json日志格式
    
    ```
