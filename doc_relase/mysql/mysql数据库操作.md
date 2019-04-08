# mysql 数据库处理

----

## 时间格式
1. date
2. datetime
3. time
4. year
5. timestamp

![mysql数据库时间格式](mysql时间格式.png)

## myql 时间处理函数

---

1. ``` DATE() ```函数：返回日期或日期时间表达式的日期部分；

2. ```str_to_date()```函数：按照指定日期或时间显示格式 将字符串转换为日期或日期时间类型；

3. ```date_format()```函数：按照指定日期或时间显示格式 输出日期或日期时间； **时间转换为字符串格式？**

说明：

str_to_date()常用于insert;

date_format() 常用于select


### ```date()``` 获取日期

```
SELECT date('2017-02-09 15:25:46.635');
```

### ```str_to_date()```字符串转换为时间格式 

```
 str_to_date(
    '2016-12-15 16:48:40',
    '%Y-%m-%d %H:%i:%S'
)
```

### ``` date_format()```时间格式化
![mysql时间格式化](mysql时间格式化.png)

```
//获取24小时制时间部分
SELECT date_format("2018-12-17 16:20:12","%T")
```

## mysql时间戳(Timestamp)类型
issue: 

## java 时间格式化

```
//分别表示：年-月-日 时-分-秒-毫秒
yyyy-MM-dd HH:mm:ss:SSS 
```


# issue

----
## 1  获取当天打卡最早，最晚时间，以及当天打卡记录。

```
CREATE TABLE `attendance_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `clock_in_time` date DEFAULT NULL COMMENT '打卡日期',
  `emp_no` int(11) DEFAULT NULL COMMENT '员工工号',
  `clock_in_record` datetime DEFAULT NULL COMMENT '打卡记录',
  `clock_in_records` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='考勤（打卡）记录'$$


SELECT emp_no,min(clock_in_record)as clock_in_time,max(clock_in_record)as clock_out_time, group_concat(clock_in_record ) as attendance_records
 FROM attendance_record group by emp_no,clock_in_time;
```