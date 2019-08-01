# work issue

-------------
## 1 spring-boot 中sql语句找不到 unbind
原因：
1 spring-boot @MapperScan 没有添加对应mapper接口文件的路经。
2 mybatis中配置的mappr.xml文件路经不对。
@MapperScan
@Mapper