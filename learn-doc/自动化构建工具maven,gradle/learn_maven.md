#Learn maven

#1 查找添加依赖
[mvnrepository.com](https://mvnrepository.com/)

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

# maven 打包

## reference
1. [参考1](https://blog.csdn.net/senpogml/article/details/52366518)
2. [参考2](https://blog.csdn.net/difffate/article/details/78002995)
3. [参考3](https://www.jianshu.com/p/dbdece9062b3)

```
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>com.brs.idm.application.BrsIdmApplication</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy-dependencies</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>${project.build.directory}/lib</outputDirectory>
                            <overWriteReleases>false</overWriteReleases>
                            <overWriteSnapshots>false</overWriteSnapshots>
                            <overWriteIfNewer>true</overWriteIfNewer>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
```

## demp

```
<project>
   <build>
        <plugins>

            <!--打包jar-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <!--不打包资源文件-->
                    <excludes>
                        <exclude>*.**</exclude>
                        <exclude>*/*.xml</exclude>
                    </excludes>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <!--MANIFEST.MF 中 Class-Path 加入前缀-->
                            <classpathPrefix>lib/</classpathPrefix>
                            <!--jar包不包含唯一版本标识-->
                            <useUniqueVersions>false</useUniqueVersions>
                            <!--指定入口类-->
                            <mainClass>site.yuyanjia.template.Application</mainClass>
                        </manifest>
                        <manifestEntries>
                            <!--MANIFEST.MF 中 Class-Path 加入资源文件目录-->
                            <Class-Path>./resources/</Class-Path>
                        </manifestEntries>
                    </archive>
                    <outputDirectory>${project.build.directory}</outputDirectory>
                </configuration>
            </plugin>

            <!--拷贝依赖 copy-dependencies-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy-dependencies</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>
                                ${project.build.directory}/lib/
                            </outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <!--拷贝资源文件 copy-resources-->
            <plugin>
                <artifactId>maven-resources-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy-resources</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-resources</goal>
                        </goals>
                        <configuration>
                            <resources>
                                <resource>
                                    <directory>src/main/resources</directory>
                                </resource>
                            </resources>
                            <outputDirectory>${project.build.directory}/resources</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

            <!--spring boot repackage，依赖 maven-jar-plugin 打包的jar包 重新打包成 spring boot 的jar包-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!--重写包含依赖，包含不存在的依赖，jar里没有pom里的依赖-->
                    <includes>
                        <include>
                            <groupId>null</groupId>
                            <artifactId>null</artifactId>
                        </include>
                    </includes>
                    <layout>ZIP</layout>
                    <!--使用外部配置文件，jar包里没有资源文件-->
                    <addResources>true</addResources>
                    <outputDirectory>${project.build.directory}</outputDirectory>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                        <configuration>
                            <!--配置jar包特殊标识 配置后，保留原文件，生成新文件 *-run.jar -->
                            <!--配置jar包特殊标识 不配置，原文件命名为 *.jar.original，生成新文件 *.jar -->
                            <!--<classifier>run</classifier>-->
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>


```