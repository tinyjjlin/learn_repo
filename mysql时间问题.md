# mysql java 前端 时间问题

## mysql
```
# 查看数据库时区
show variables like "%time_zone%";
set global time_zone = '+8:00';
set global time_zone = '+8:00'; ##修改mysql全局时区为北京时间，即我们所在的东8区
set time_zone = '+8:00'; ##修改当前会话时区
flush privileges; #立即生效

```
## 数据驱动连接设置
```
# serverTimezone=HongKong/Asia/Shanghai/CTT
jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=false&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=Asia/Shanghai
```

## mysql 时区设置函数
```
convert_tz(dt,from_tz,to_tz)
convert_tz(now(),'+00:00','+08:00')
```
## LocalDateTime 时间 中有个'T'
```
  @Override
    public String toString() {
        return date.toString() + 'T' + time.toString();
    }
```

###  去除 时间中的'T'

1. springboot日期返回前端显示的yyyy-MM-dd 'T' HH:mm:ss问题记录

```
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8
#spring.jackson.serialization.WRITE_DATES_AS_TIMESTAMPS=true(也可以直接返回时间戳)

```

2.
```
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
```
3. fastjson 时间格式化
```
1.JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";//设置日期格式

2.JSONObject.toJSONString(resultMap, SerializerFeature.WriteMapNullValue,SerializerFeature.DisableCircularReferenceDetect,

SerializerFeature.WriteDateUseDateFormat);

但是上面的解决方案面临一个问题，如果不满足上面的条件（多个date属性，而且需要按照不定的格式序列化这些日期属性），那么我们就需要另辟蹊径，使用fastjson的特性来完成：
@JSONField(format="yyyyMMdd")
    private Date date;
@JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date1;
```