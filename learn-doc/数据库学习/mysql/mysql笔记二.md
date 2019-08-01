http://172.19.0.2:3000/j100057/brs_oa_doc.git# mysql 笔记二

---

### mysql 
```
SET SQL_SAFE_UPDATES=0; 

```


# mysql 笔记二

----

## 索引
1创建索引
```
create index indexName on mytable(username(length))
```
如果是CHAR，VARCHAR类型，length可以小于字段实际长度；如果是BLOB和TEXT类型，必须指定 length。

2添加索引
```
alter table tableName add index indexName(columnName)
```

3 创建表的时候指定索引
```
CREATE TABLE mytable(  
 
ID INT NOT NULL,   
 
username VARCHAR(16) NOT NULL,  
 
INDEX [indexName] (username(length))  
 
);  

```

4删除索引
```
drop index indexName on mytable;
```

5显示索引信息

```
SHOW INDEX FROM table_name; \G
```

### 索引分类

联合索引

[联合索引refrence](https://www.cnblogs.com/joyber/p/4349604.html)


## mysql on duplicate key update 重复插入时更新
[refrence](https://www.cnblogs.com/Dong-Ge/p/6518071.html)