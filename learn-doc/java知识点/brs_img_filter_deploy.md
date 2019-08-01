# 图片筛选部署文档

图片刷选项目所在git 仓库地址：[brs_image_recognition](http://git.beiruosi.wang:3000/j100057/brs_image_recognition.git)

## 1 部署环境
## 1.1 安装最新的 node，npm
```
sudo apt-get install node 
node -v
npm -v
```
需要安装插件
1. express
2. express-http-proxy

执行
```
#进入 brs_image_recogniton目录
# 切换到 node-server目录下
cd node-server
#安装npm 插件
npm install

```

## 1.2 安装 Python 3.5 ,pip 3.5
需要pip 安装的模块有
1. opencv-python
2. scikit-image
3. pandas
4. flask
5. pymysql
6. numpy
7. scipy
8. watchdog
9. Werkzeug
10. matplotlib
11. imageio

##  2 修改配置文件
## 2.1 修改 node server 配置文件
1. 进入node-server目录下，打开app.js文件。修改config对象。启用prod env 。注释掉 local dev，test dev。
2. 修改生产环境配置
只需要修改 ip,port,proxyPath为生产环境地址

```
// prod env=========================================
const config={
    ip: '172.18.19.3',
    port: 8020,
    proxyPath: 'http://172.18.19.3:8021',
    imgResDir: '/var/brs-img-filter/imgRes',
    markImgDir: '/var/brs-img-filter/markImg',
    cutImgDir: '/var/brs-img-filter/cutImg',
    staticPage: '/usr/share/web/dist',
}


```
## 2.1 修改Python 配置文件
1. 进入python-script目录，打开image_config.py文件。启用 prod env。注释掉local env,test env。
2. 修改生产环境配置
只需要修改 SERVER_HOST，SERVER_PORT，mysql setting
```
# 标记图片所在目录
MARK_IMG_DIR = '/var/brs-img-filter/markImg'
# 剪接图片所在目录
CUT_IMG_DIR = '/var/brs-img-filter/cutImg'
# 图片资料路径
IMAGE_RESOURCE = '/var/brs-img-filter/imgRes'

# server setting
SERVER_HOST = '172.18.19.3'
SERVER_PORT = 8021

# mysql setting
DB_HOST = '172.18.19.2'
DB_PORT = 4000
DB_USER = 'srv_labimg'
DB_PASSWORD = 'srv_labimg'
DATABASE = 'brs_img_res'

```

## 3 添加生产环境msql数据库
1. 在生产环境中创建数据库，数据库的名称要和python 配置文件中的数据名称一致。
2. 可以通过python脚本创建表。
```
# 进入python-script目录下，执行db_init.py脚本。创建 img_info ,img_download_record 两张表

python3 db_init.py

```
## 4 启动node，python服务
1. 进入scripts目录下，执行startup-prod.sh添加必要的文件
2. 进入scripts目录下，执行luanched.sh启动node,python服务
