
# brs_oa
=======

# 贝若偲 OA系统 后台服务接口测试

----

## 步骤：

### 1 repository address 
  http://172.19.0.2:3000/j100057/brs_oa.git

### 2 启动服务，打开swagger网页

 http://localhost:8080/swagger-ui.html


### 3 打开 /login 接口
填写 用户名，密码

测试账号：

```
username: j100057
password: 123456

username: w100005
password: 123456

username: boss
password: 123456

username: salaryAll
password: 123456

username: salaryOwn
password: 123456
```
登录成功后，会返回token字符串。将值ctrl+c复制。

### 4  打开其他接口将复制的token值粘贴到 Authorization 中。

## redis 服务配置

----
1 安装redis-Windows 服务

redis 文件在:南京网盘-->IT-->tools下。

2 启动redis 服务

cmd--->redis-server

3 在 application.properties中修改redis 配置



