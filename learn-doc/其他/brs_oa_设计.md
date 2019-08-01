# BRS OA 系统设计

-----
## 权限模块

### 功能权限

### 数据权限
不同实体对表字段拥有不同权限。

具体问题：

1 update 操作时，只能操作指定字段。
```
UPDATE table_name SET field1=new-value1, field2=new-value2
[WHERE Clause]

//
update table_name set #{fields} 如何处理？
```

2 select 操作时，只能返回指定字段。
```
SELECT column_name,column_name
FROM table_name
[WHERE Clause]
[LIMIT N][ OFFSET M]
```

实现方案：

第一种，返回所有字段，然后进行过滤，根据过滤规则（过滤规则可以保持在数据库中），返回指定字段数据。

第二种，根据过滤规则，进行查询操作。（1可以针对借口进行编程，2可以针对对sql语句），然后根据过滤规则返回指定字段数据。

3 页面显示时，隐藏主键。

实现方案：
    
1页面有主键字段但是不显示，这样可能不安全；

2 对主键字段进行加密，后台服务获取字段再解密。



### 数据权限解决方案：
采用AOP ，对模块（业务）的具体操作，查询，更新。进行权限控制。

