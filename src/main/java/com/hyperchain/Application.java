package com.hyperchain;

import com.hyperchain.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        //指定配置文件位置
//		new SpringApplicationBuilder(Application.class)
//				.properties("spring.config.location=classpath:/test-folder/my-config.properties")
//				.properties("spring.profiles.active=profiles1")
//				.run(args);
        logger.info("The service to start.");
        SpringApplication.run(Application.class, args);
        logger.info("The service has started.");
    }
}
