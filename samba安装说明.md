# Samba 安装说明
## 简介
Samba是在Linux和UNIX系统上实现SMB协议的一个免费软件。SMB（Server Messages Block，信息服务块）通信协议是微软（Microsoft）和英特尔(Intel)在1987年制定的协议，主要是作为Microsoft网络的通讯协议，是一种在局域网上共享文件和打印机的一种通信协议，它为局域网内的不同计算机之间提供文件及打印机等资源的共享服务。SMB协议是客户机/服务器型协议，客户机通过该协议可以访问服务器上的共享文件系统、打印机及其他资源。通过设置“NetBIOS over TCP/IP”使得Samba不但能与局域网络主机分享资源，还能与全世界的电脑分享资源。后来微软又把 SMB 改名为 CIFS（Common Internet File System），即公共 Internet 文件系统

## linux install samba
```
apt install samba
apt install smbclient

systemctl status nmdb.service
systemctl status smbd.service

systemctl enable nmdb.service
systemctl enable smbd.service
```

## Samba 配置文件 
### 1 /etc/Samba/smb.conf
```
guest account = nobody # guest 用户对应的系统用户名
```

### 共享选项说明
1. [共享名称]
2. comment =
3. path = 
4. browseable =yes/no 
5. writable = yes/no
6. read only = yes/no
7. availabe = yes/no
8. admin users = brsdev,root
9. public = yes/no
10. guest ok = yes/no
11. create mask = 0700
12. directory mask = 0700


## issue & resolve
1. 上传的文件所属用户为 nobody ,[global] guest account = brsdev

## reference
1. [Debian9.5 系统Samba配置说明](https://blog.csdn.net/Pipcie/article/details/88220071)
2. [samba_doc](https://www.samba.org/samba/docs/man/)
