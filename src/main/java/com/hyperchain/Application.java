package com.hyperchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        //指定配置文件位置
//		new SpringApplicationBuilder(Application.class)
//				.properties("spring.config.location=classpath:/test-folder/my-config.properties")
//				.properties("spring.profiles.active=profiles1")
//				.run(args);

        SpringApplication.run(Application.class, args);
    }
}
