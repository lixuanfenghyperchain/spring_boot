package com.hyperchain.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(OrderRunner1.class);
    @Override
    public void run(String... args) throws Exception {
        logger.info("The OrderRunner1 start to initialize ...");
    }
}