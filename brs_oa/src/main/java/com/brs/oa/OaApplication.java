package com.brs.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author tiny lin
 * @date  2018/11/30
*/

@SpringBootApplication
@MapperScan("com.brs.oa.*.mapper")
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableScheduling
public class OaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
    }
}
