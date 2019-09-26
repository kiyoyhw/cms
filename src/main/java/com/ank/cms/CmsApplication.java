package com.ank.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.ank.cms")
@MapperScan("com.ank.cms.dao")
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
public class CmsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
