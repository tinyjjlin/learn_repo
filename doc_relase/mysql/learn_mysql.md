#Learn mysql
##1.查看mysql数据库物理存放路径
`` mysql> show global variables like "%datadir%";``
##2.msyql 导入外部sql文件。出现乱码问题？
```
mysql -u root -p --default-character-set=utf8 
use dbname 
source /root/newsdata.sql 
```
##3.查询表的结构，字段
``  desc user; ``