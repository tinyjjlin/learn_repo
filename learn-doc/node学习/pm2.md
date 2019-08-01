# pm2
>PM2是node进程管理工具，可以利用它来简化很多node应用管理的繁琐任务，如性能监控、自动重启、负载均衡等，而且使用非常简单。

---
## 参考
1. [refer1 https://www.jianshu.com/p/f640450bd120](https://www.jianshu.com/p/f640450bd120)
2. 官方文档1：http://pm2.keymetrics.io/docs/usage/pm2-doc-single-page/(http://pm2.keymetrics.io/docs/usage/pm2-doc-single-page/)

3. 官方文档2：[http://pm2.keymetrics.io/docs/usage/quick-start/](http://pm2.keymetrics.io/docs/usage/quick-start/)

4. PM2实用入门指南：[http://www.cnblogs.com/chyingp/p/pm2-documentation.html](http://www.cnblogs.com/chyingp/p/pm2-documentation.html)

5. nodejs高大上的部署方式-PM2: [http://www.2cto.com/kf/201501/367718.html](http://www.2cto.com/kf/201501/367718.html)


## install
`npm install pm2@latest -g`

## 常用命令
最简单的启用一个应用:  `pm2 start app.js`

1. 停止：`pm2 stop app_name|app_id`

2. 删除：`pm2 delete app_name|app_id`

3. 重启：`pm2 restart app_name|app_id`

4. 停止所有：`pm2 stop all`

5. 查看所有的进程：`pm2 list`

6. 查看所有的进程状态：`pm2 status`

7. 查看某一个进程的信息：`pm2 describe app_name|app_id`

## pm2 管理其它脚本
http://pm2.keymetrics.io/docs/usage/application-declaration/

生产级部署 Python 脚本，日志收集、崩溃自启，一键搞定

https://blog.csdn.net/qq_40925239/article/details/83011890

```
interpreter:''//指定调用的脚本
interpreter_agrs:''//脚本调用参数

```
PM2 在默认情况下，是通过脚本文件后缀来判断的，如果没有后缀就需要强制指定 `--interpreter` 。
```
{
  ".sh": "bash",
  ".py": "python",
  ".rb": "ruby",
  ".coffee" : "coffee",
  ".php": "php",
  ".pl" : "perl",
  ".js" : "node"
}
```