#win doc 常用命令

1. cmd要获取管理员权限。

[cmd.exe](  C:\Windows\WinSxS\wow64_microsoft-windows-commandprompt_31bf3856ad364e35_10.0.10586.0_none_21e70967f9147e9b)

##1 创建，删除文件夹
```
md [filefolderName]
mkdir  [filefolderName]

rd [filefolderName]
rmdir [filefolderName]
```
删除文件或目录CMD命令：
rd/s/q D:\app  （强制删除文件文件夹和文件夹内所有文件）del/f/s/q D:\app.txt    （强制删除文件，文件名必须加文件后缀名）


##2 创建文件，空白文件，有内容的文件
```
type nul>[filName]
echo "content>[fileName]

```
##3 查看当前目录下所有文件
```
dir

```
