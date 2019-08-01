# Thymeleaf Properties

# THYMELEAF (ThymeleafAutoConfiguration)
#开启模板缓存（默认值：true）
spring.thymeleaf.cache=true
#Check that the template exists before rendering it.
spring.thymeleaf.check-template=true
#检查模板位置是否正确(默认值:true)
spring.thymeleaf.check-template-location=true
#Content-Type的值（默认值：text/html）
spring.thymeleaf.content-type=text/html
#开启MVC Thymeleaf视图解析(默认值：true)
spring.thymeleaf.enabled=true
#模板编码
spring.thymeleaf.encoding=UTF-8
#要被排除在解析之外的视图名称列表，用逗号分隔
spring.thymeleaf.excluded-view-names=
#要运用于模板之上的模板模式。另见StandardTemplate-ModeHandlers(默认值：HTML5)
spring.thymeleaf.mode=HTML5
#在构建URL时添加到视图名称前的前缀（默认值：classpath:/templates/）
spring.thymeleaf.prefix=classpath:/templates/
#在构建URL时添加到视图名称后的后缀（默认值：.html）
spring.thymeleaf.suffix=.html
#Thymeleaf模板解析器在解析器链中的顺序。默认情况下，它排第一位。顺序从1开始，只有在定义了额外的TemplateResolver Bean时才需要设置这个属性。
spring.thymeleaf.template-resolver-order=
#可解析的视图名称列表，用逗号分隔
spring.thymeleaf.view-names=

ThymeleafProperties
spring.thymeleaf
//1 检查模板是否存在
checkTemplate=true
//2检查
checkTemplateLocation=true
//3前缀
prefix = classpath:/templates/
//4 后缀
suffix =.html
//5
model="html"
//6
encoding="utf-8"
//7
cache=true
//8
viewNames
excludedViewNames
