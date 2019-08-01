# java 时间相关函数

1. Calendar 日历
2. Date 日期
3. DateFormat 日期格式

## 1. Date
java.util.Date

## 2. DateFormat
java.text.DateFormat,java.text.SimpleDateFormat

## 3. Calendar
java.util.Calendar,java.util.GregorianCalendar

## java 8 引入新的时间日期api 
1. LocalDate 日期
2. LocalTime 时间
3. LocalDateTime 日期+时间
4. Clock 时钟
5. Instant 时间戳

这些的类的设计都使用了不变模式，因此是线程安全的设计。


## Java 格式化字母表
```
Symbol  Meaning Presentation    Example
G   era designator  Text    AD
y   year    Number  2009
M   month in year   Text & Number   July & 07
d   day in month    Number  10
h   hour in am/pm (1-12)    Number  12
H   hour in day (0-23)  Number  0
m   minute in hour  Number  30
s   second in minute    Number  55
S   millisecond Number  978
E   day in week Text    Tuesday
D   day in year Number  189
F   day of week in month    Number  2 (2nd Wed in July)
w   week in year    Number  27
W   week in month   Number  2
a   am/pm marker    Text    PM
k   hour in day (1-24)  Number  24
K   hour in am/pm (0-11)    Number  0
z   time zone   Text    Pacific Standard Time
'   escape for text Delimiter   (none)
'   single quote    Literal '
```
demo

```
yyy-MM-dd
yyy-MM-dd HH:mm:ss
```


## springboot 类型转换

参考 [spring boot 请求参数增加string 转date转换器](http://www.bubuko.com/infodetail-1113295.html)

## 参考
1. [java8中的时间类LocalDate、LocalTime、LocalDateTime使用总结](这些的类的设计都使用了不变模式，因此是线程安全的设计。)