# learn springboot 

## issue-01 fastJson 读servletRequest出错。
```
java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
```
reason:

ServletRequest,ServletResponse,MultipartFile不能序列化。

resolve:
exclude them

## issue-02 filter 异常统一处理？

reference:

1. [Spring boot 统一处理Filter异常](https://blog.csdn.net/qq_19457117/article/details/88633225)
2. [解决springboot/springmvc过滤器内的错误抛不出的问题](https://blog.csdn.net/u011943534/article/details/82468173)
3. [SpringBoot统一异常拦截处理(filter中的异常无法被拦截处理)](https://blog.csdn.net/weixin_41103806/article/details/87777285)




## springboot 使用 filter 方式
1. impments filter 过滤所有请求；
2. 注册 filter 指定过滤请求
```
1 @WebFilter标识Filter,@Order指定执行顺序；
2 @ServletComponentsScan添加到启动类上，使可以正常使用自定义过滤器。
```
3. FilterRegistrationBean注册Filter