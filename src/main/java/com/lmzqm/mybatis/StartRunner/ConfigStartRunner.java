package com.lmzqm.mybatis.StartRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by lmzqm on 2017/6/30.
 */
@Order(value = 2)
@Component
public class ConfigStartRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(FileStartRunner.class);
    @Override
    public void run(String... strings) throws Exception {
        logger.info("run ConfigStartRunner order 2");
    }
}
