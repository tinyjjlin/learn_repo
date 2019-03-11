# spring进阶学习

---
## 注解 annotation

---
1. 什么是注解？
2. 注解的作用，功能？
3. 如何定义注解？

讲解的很好
[ref:1](https://blog.csdn.net/javazejian/article/details/71860633)

个人理解：注解就是一种说明，一种标签。运行期间存活时，可以通过反射，获取其定义的内容。

spring 注解 ``@Autowired(require = false)``的使用 [ref:1](https://blog.csdn.net/ywl470812087/article/details/80320146) ; [ref:2](https://blog.csdn.net/weixin_40423597/article/details/80643990)

## spring BeanFactory ApplicationContext
当ApplicationContext容器初始化完成后，容器中所有的 singleton Bean 也都被实例化了，也就是说当你需要使用singleton Bean 是，在应用中无需等待就可以用，而其他BeanFactory接口的实现类，则会延迟到调用 getBean（）方法时构造，ApplicationContext的初始化时间会稍长些，调用getBean（）是由于Bean已经构造完毕，速度会更快

## spring AOP

学习Java reflect ，对 Proxy进行源码分析。如何实现动态代理的。

参考学习 

[ref:1](https://www.cnblogs.com/bigben0123/p/7779357.html)

[ref:2](https://www.cnblogs.com/liuruowang/p/5711563.html)

[ref:3](https://www.cnblogs.com/bigben0123/p/7779357.html)

 springboot AOP 

掌握：Filter、HandlerInterceptor、MethodInterceptor

 springboot AOP 的具体应用 权限管理，日志，事务

测试接口的工具：SoapUI Jmeter Postman loadRunner [ref](https://blog.csdn.net/huilan_same/article/details/75413482)

aop 实现权限管理 [ref](https://blog.csdn.net/u010520626/article/details/79422949)

aop 事务  [ref](https://www.cnblogs.com/sweetchildomine/p/6978037.html?utm_source=itdadao&utm_medium=referral)
[ref:2事务 拦截器](https://www.cnblogs.com/saaav/p/6905481.html)

## spring 源码分析

BeanFactory 

用于管理Bean的工厂。采用反射实现具体Bean。

包含：实例化，

FactoryBean

是一个Bean，获取此类型Bean实际上是FactoryBean 的 getObject()返回的对象，不是FactoryBean本身。

应用： 代理功能，如对该对象的所以方法做个拦截，日志等。  


