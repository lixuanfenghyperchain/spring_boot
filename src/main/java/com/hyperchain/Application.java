package com.hyperchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
//@EnableScheduling     //开启定时任务
@EnableCaching          //开启缓存
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
