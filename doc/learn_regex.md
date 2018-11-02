#正则表达 regular express
##1. 基础知识
1. 元字符
```
.   匹配任意字符（除换行符）
\w  匹配字母，数字，下划线，汉字
\s  匹配任意的空白符
\d  匹配数字
\b ^
$
```
2. 限定符

说明：限定符是作用在他左边最近的一个字符
```
*
+
?
{n},{n,}{n,m}

```
3. 转义
`` \  ``
4. 条件或
`` | ``
5. 区间
```
[]
[0-9]
[A-Z]
[165]
```

##2 进阶
###2.1 断言
断言指定位置，不占字符
1. 正向先行断言

语法： （？=pattern）
```
String reg=
String str=
Pattern pattern = Pattern.cmpile(reg);
Matcher mc = pattern.matcher(str);
while (mc.find()){mc.group()}

````
作用：匹配pattern表达式的前面的内容，不返还本身。

##3 捕获和非捕获

