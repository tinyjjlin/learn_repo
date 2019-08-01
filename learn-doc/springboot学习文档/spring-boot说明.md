# spring boot

## 1 Configuration Processor 配置处理器
参考： [refs1](https://www.xttblog.com/?p=2834)

## @ControllerAdvice

## ResponseBodyAdvice
修改返回值，加密。

[参考](https://www.cnblogs.com/soul-wonder/p/9084318.html)



## Springboot 全局异常处理 404异常

### 参考
1. [SpringBoot 之全局异常处理==>附捕获404异常](https://blog.csdn.net/yali_aini/article/details/84638747)

解决方案：

1 application.properties
```
## 出现错误时直接抛出异常
#spring.mvc.throw-exception-if-no-handler-found=true
## 取消 项目中资源文件的映射
#spring.resources.add-mappings=false
```
2 
```
package com.tiny.springbootrestapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author tiny lin
 * @date 2019/5/11
 */
@Configuration
public class WebResMappingConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/","/static", "/public");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}

```

## springboot LocalDateTime 格式处理
1 request 接收 string 日期时间格式数据。

@DateTimeFormat()

### 参考：
1. [Spring Boot LocalDateTime格式处理](https://j2ees.iteye.com/blog/2404704)