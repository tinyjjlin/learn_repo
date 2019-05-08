# Gunicorn
python HTTP 服务器

Gunicorn - 绿色独角兽（Green Unicorn），是一个Python WSGI UNIX的HTTP服务器。Gunicorn主要是预先fork进程，实现多进程处理请求，提升web的性能。Gunicorn服务器广泛兼容各种web框架,简单地实现,服务器资源,和相当迅速。

[官方文档参考](http://docs.gunicorn.org/en/stable/settings.html#server-mechanics)

#  获取进程树
```
pstree -ap|grep gunicorn
```

# install
```
pip install gunicorn
gunicorn -h
```

# gunicorn的参数详解
```
-c CONFIG    : CONFIG,配置文件的路径，通过配置文件启动；生产环境使用；

-b ADDRESS   : ADDRESS，ip加端口，绑定运行的主机；

-w INT, --workers INT：用于处理工作进程的数量，为正整数，默认为1；

-k STRTING, --worker-class STRTING：要使用的工作模式，默认为sync异步，可以下载eventlet和gevent并指定

--threads INT：处理请求的工作线程数，使用指定数量的线程运行每个worker。为正整数，默认为1。

--worker-connections INT：最大客户端并发数量，默认情况下这个值为1000。

--backlog int：未决连接的最大数量，即等待服务的客户的数量。默认2048个，一般不修改；

-p FILE, --pid FILE：设置pid文件的文件名，如果不设置将不会创建pid文件


--access-logfile FILE   ：  要写入的访问日志目录

--access-logformat STRING：要写入的访问日志格式

--error-logfile FILE, --log-file FILE  ：  要写入错误日志的文件目录。

--log-level LEVEL   ：   错误日志输出等级。


--limit-request-line INT   ：  HTTP请求头的行数的最大大小，此参数用于限制HTTP请求行的允许大小，默认情况下，这个值为4094。值是0~8190的数字。

--limit-request-fields INT   ：  限制HTTP请求中请求头字段的数量。此字段用于限制请求头字段的数量以防止DDOS攻击，默认情况下，这个值为100，这个值不能超过32768

--limit-request-field-size INT  ：  限制HTTP请求中请求头的大小，默认情况下这个值为8190字节。值是一个整数或者0，当该值为0时，表示将对请求头大小不做限制


-t INT, --timeout INT：超过这么多秒后工作将被杀掉，并重新启动。一般设定为30秒；

--daemon： 是否以守护进程启动，默认false；

--chdir： 在加载应用程序之前切换目录；

--graceful-timeout INT：默认情况下，这个值为30，在超时(从接收到重启信号开始)之后仍然活着的工作将被强行杀死；一般使用默认；

--keep-alive INT：在keep-alive连接上等待请求的秒数，默认情况下值为2。一般设定在1~5秒之间。

--reload：默认为False。此设置用于开发，每当应用程序发生更改时，都会导致工作重新启动。

--spew：打印服务器执行过的每一条语句，默认False。此选择为原子性的，即要么全部打印，要么全部不打印；

--check-config   ：显示现在的配置，默认值为False，即显示。

-e ENV, --env ENV： 设置环境变量；

```

# 配置文件方式启动
```
# gunicorn.conf

# 并行工作进程数
workers = 4
# 指定每个工作者的线程数
threads = 2
# 监听内网端口5000
bind = '127.0.0.1:5000'
# 设置守护进程,将进程交给supervisor管理
daemon = 'false'
# 工作模式协程
worker_class = 'gevent'
# 设置最大并发量
worker_connections = 2000
# 设置进程文件目录
pidfile = '/var/run/gunicorn.pid'
# 设置访问日志和错误信息日志路径
accesslog = '/var/log/gunicorn_acess.log'
errorlog = '/var/log/gunicorn_error.log'
# 设置日志记录水平
loglevel = 'warning'

```

{
    name: 'pythonflask',
    cwd: './brs-img-flask',
    script: 'boot.sh',

    // Options reference: https://pm2.io/doc/en/runtime/reference/ecosystem-file/
    args: '',
    instances: 1,
    autorestart: true,
    watch: false,
    max_memory_restart: '1G',
   // interpreter:'/usr/local/bin/gunicorn',
   // interpreter_args: '-harmony',
    env: {
      PYTHON__ENV: 'prod'
    },
    env_test: {
      PYTHON_FLASK_ENV: 'test'
    },
    env_dev: {
      PYTHON_FLASK_ENV: 'dev'
    },
  }
