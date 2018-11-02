#maven使用
##1. maven 命令

1. mvn命令创建javar项目
```
mvn archetype:generate -DgroupId=com.lin.company -DartifactId=simple -DarchetypeArtifactId=maven-archetype-quickstart
```
2. mvn 命令创建web项目
```
mvn archetype:generate -DgroupId=com.lin.maven -DartifactId=myWebApp -DarchetypeArtifactId=maven-archetype-webapp -Dversion=0.0.1-snapshot
```

##2. Eclipse中使用maven

1. Eclipse->preferences->Maven->installations 添加本地下载的maven

2. Eclipse->preferences->User Settings 选择settings.xml

3. 创建maven项目

![第一步](./doc_img/eclipse_maven_01.png)

![第二步](./doc_img/eclipse_maven_02.png)
