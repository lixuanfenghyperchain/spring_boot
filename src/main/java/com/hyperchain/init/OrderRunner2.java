package com.hyperchain.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//springBoot启动完成之后初始化资源
//@Component
//@Order(2)
public class OrderRunner2 implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(OrderRunner2.class);
    @Override
    public void run(String... args) throws Exception {
       logger.info("The OrderRunner2 start to initialize ...");
    }
}