package com.lmzqm.mybatis.StartRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by lmzqm on 2017/6/30.
 */
@Order(1)
@Component
public class FileStartRunner implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(FileStartRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        //这是默认启动程序的时候会运行的程序
        System.out.println(">>>>>>>>>服务器启动的时候先执行这个<<<<<<<<<<<<");
        logger.info("run FileStartRunner order 1");

    }
}
