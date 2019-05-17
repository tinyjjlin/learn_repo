# maven 学习笔记

---
##maven 常用命令
```
1. mvn -version mvn -v
2. mvn clean
3. mvn compile
4. mvn package
5. mvn instatll
6. mvn mvn deploy
7. mvn test
8. mvn site
9. mvn dependency:tree
#打包时跳过单元测试
10. mvn -Dmaven.test.skip =true
```

## maven 内置属性

 [参考](https://blog.csdn.net/bao19901210/article/details/52415402)

1 内置属性
```
#表示项目根目录
${basedir} 
#表示项目版本
${version}
```
2 POM属性
```
1. ${project.groupId}
2. ${project.artifactId}
# src/main/java/
3. ${project.build.sourceDirecotry}
# /src/test/java/.
4. ${project.build.testSourceDirectory}
# target/.
5. ${project.build.direcotry}
# target/classese/.
6. ${project.build.outputDirecotry}
# target/testclasses/.
7. ${project.build.testOutputDirecotry}
```
3 自定义属性
```
<properties>
    <mv.prop>hello</mv.prop>
</properties>
```
4 Settings属性

与POM属性同理。如${settings.localRepository}指向用户本地仓库的地址。

5 Java系统属性

所有Java系统属性都可以使用Maven属性引用，例如${user.home}指向了用户目录。可以通过命令行mvn help:system查看所有的Java系统属性

6 环境变量属性

所有环境变量都可以使用以env.开头的Maven属性引用。例如${env.JAVA_HOME}指代了JAVA_HOME环境变量的值。也可以通过命令行mvn help:system查看所有环境变量。

## maven build

[参考](https://blog.csdn.net/glory1234work2115/article/details/51550250)

## maven plugin 执行生命周期 lifecycle phase goal
[参考1]（https://blog.csdn.net/bluishglc/article/details/6632280）

[参考2]（https://blog.csdn.net/xbynet/article/details/52779678）