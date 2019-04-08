# Docker 学习笔记

----

## Docker 命令

1 Docker 删除容器镜像
```
//停止所有容器
docker stop $(docker ps -a -q)
//删除所有容器
docker rm $(docker ps -a -q)
//删除镜像
docker rmi <image id>
```
想要删除untagged images，也就是那些id为<None>的image的话可以用

docker rmi $(docker images | grep "^<none>" | awk "{print $3}")

要删除全部image的话

docker rmi $(docker images -q)

2 
```
systemctl start docker
systemctl stop docker 
```
3
```
docker images
docker ps -a
```

4 docker build
```
-f
-t
 docker build -t nginx/v3:1.0.2

 docker run --name  -d -p
```