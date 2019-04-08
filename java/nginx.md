# Nginx

---
## 在不加入第三方包情况下的作用：
1. 反向代理
2. 负载均衡
3. HTTP 服务器 包含动静分离
4. 正向代理

## nginx config 
设置虚拟服务器
```
http {
    server{
        #server configuration
        listen 80;
        sever_name:localhost;
        location /some/path/{

        }
    }
}

// ~ 正则表达式之前是区分大小写匹配
// ~* 表示不区分大小写匹配
```

