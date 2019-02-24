package com.liutao;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages={"com.liutao.*.mapper"})
public class SpringdemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringdemoApplication.class);

    public static void main(String[] args) {

		SpringApplication.run(SpringdemoApplication.class, args);

        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn("=========================================> SpringBoot Started .");
        }

    }

}
