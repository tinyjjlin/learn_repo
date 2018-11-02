#redis config

```
#redis config
# REDIS (RedisProperties)
# Redis index default 0
spring.redis.database=0
# Redis host
spring.redis.host=127.0.0.1
# Redis port
spring.redis.port=6379
# pswd default null
spring.redis.password=
#
spring.redis.pool.max-active=8
#
spring.redis.pool.max-wait=-1
#
spring.redis.pool.max-idle=8
#
spring.redis.pool.min-idle=0
#
spring.redis.timeout=0

#mybatis config
mybatis.type-aliases-package=com.lin.Crystal.entry

spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/crystal?useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.username = root
spring.datasource.password = root


#thymelea模板配置
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML5
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.content-type=text/html
spring.thymeleaf.cache=false
spring.resources.chain.strategy.content.enabled=true
spring.resources.chain.strategy.content.paths=/**

```