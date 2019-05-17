# learn gradle

## Gradle 使用仓库
```

repositories {
    mavenLocal()
    maven { url "http://maven.aliyun.com/nexus/content/groups/public/"}
    mavenCentral()
    jcenter()
    maven { url "https://repo.spring.io/snapshot" }
    maven { url "https://repo.spring.io/milestone" }
    maven { url 'http://oss.jfrog.org/artifactory/oss-snapshot-local/' }  //转换pdf使用
```
说明：

1. 指定本地仓库
mavenLocal() 时Gradle默认会按以下顺序去查找本地的maven仓库：USER_HOME/.m2/settings.xml >> M2_HOME/conf/settings.xml >> USER_HOME/.m2/repository。注意，环境变量要加入M2_HOME， 我们配环境时很多时候都是使用MAVEN_HOME或者直接在path中输入bin路径了，导致mavenLocal无法生效。
mavenLocal()：指定使用maven本地仓库，而本地仓库在配置maven时setting文件指定的仓库位置。如<localRepository>D:/repository</localRepository>，同时将setting文件拷贝到C:\Users\Administrator\.m2目录下，一般该目录下是没有setting文件的，gradle查找jar包顺序如下：gradle默认会按以下顺序去查找本地的仓库：USER_HOME/.m2/settings.xml >> M2_HOME/conf/settings.xml >> USER_HOME/.m2/repository。 
maven { url "http://maven.aliyun.com/nexus/content/groups/public/"}：指定阿里云镜像加速地址 
mavenCentral()：这是Maven的中央仓库，无需配置，直接声明就可以使用 
jcenter():JCenter中央仓库，实际也是是用的maven搭建的，但相比Maven仓库更友好，通过CDN分发，并且支持https访问。 
后面的maven { url 地址}，指定maven仓库，一般用私有仓库地址或其它的第三方库 
gradle按配置顺序寻找jar文件。如果本地存在就不会再去下载。不存在的再去maven仓库下载，这里注意下载下来的jar文件不在maven仓库里，而是在gradle的主工作目录下，如上面的D:\.gradle目录 

参考：

1. [Gradle实战](http://www.souvc.com/?p=2573)
2. [IDEA gradle 配置使用](https://blog.csdn.net/achenyuan/article/details/80682288)

## gradle.build 构建脚本
```
buildScript {
    repositories {
         mavenCentral()
    }
}

repositories {
     mavenCentral()
}

```

