#Webservice
##1 what' the webservice?

使用http协议接收和响应外部系统的某种请求。从而实现远程调用.
1.知识点

1. xml
2. namespace
3. xmlns="http://itcst.cn",xmlns:it=""
4. wsdl web服务描述语言

作用：

   说明服务的地址

   说明服务提供什么样的方法-如何调用

5. soap 简单对象访问协议
说明：

soap= 在http基础上+xml数据
SOAP的组成如下：

Envelope – 必须的部分。以XML的根元素出现。
Headers – 可选的。
Body – 必须的。在body部分，包含要执行的服务器的方法。和发送到服务器的数据。

##2 怎样实现？

##3 demo

##4 自己如何使用

##5 面试
webbservice是什么。 1.基于WEB的服务，服务端整出一些资源让客户端应用访问（提供数据） 2.webservice是一个跨语言跨平台的规范（抽象） 3.是多个跨语言跨平台的应用间通信整合的方案（实际）
webservice相当于什么。 http + xml + schema
如何发布一个webservice 1.定义SEI（接口） @webservice（类） @webMethod（暴露的方法） 2.定义SEI的实现 3.发布Endpoint.publish(url,new SEI的实现对象)
如何请求一个webservice 1.根据wsdl文档生成客户端代码 jdk wsimport -keep wsdl路径 cxf wsdl2java wsdl路径 2.根据生成的代码调用webservice 找到wsdl文档中service标签的name属性对应的类，找到这个port标签的name属性 调用这个方法
wsdl（WebService Definition Language）是什么。 1.webservice定义语言，对应.wsdl文档 2.定义了webservice服务器端和客户端应用交互传递请求数据的格式和过程 3.一个webservice对应一个唯一的wsdl文档
SOAP（Simple Object Access Protocal）简单对象访问协议 1.是一种简单的，基于HTTP和XML的协议，用于在WEB交换结构化(XML)的数据 2.SOAP消息：请求消息和响应消息 3.HTTP+XML片断
SEI（WebService EndPoint Interface） 1.web服务器端处理请求的接口
CXF : Celtix+XFire 1.apache的用于开发webservice服务器端和客户端的框架