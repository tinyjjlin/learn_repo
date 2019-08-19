# mysql 学习总结

## read mysql documents
仔细阅读mysql 官方文档，很多细节部分文档中都有描述
参考：[https://dev.mysql.com/doc/refman/8.0/en/comments.html](https://dev.mysql.com/doc/refman/8.0/en/comments.html)

## JSON 数据格式


## mysql 不同版本驱动不同
```
driver =com.mysql.cj.jdbc.Driver
driver =com.mysql.jdbc.Driver

jdbc:mysql://localhost:3306/holiday?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true
```



## mysql keywords，build-in functions
mysql 定义变量的时候最好不要使用关键字，如果使用，请有反单引号''，如`context`

参考： [MySql 5.7关键字和保留字-附表](https://www.cnblogs.com/Z-Fanghan/p/6892944.html)
