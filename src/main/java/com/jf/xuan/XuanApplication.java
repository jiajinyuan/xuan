package com.jf.xuan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * XuanApplication
 *
 * @author Junfeng
 */
@EnableAsync
@MapperScan("com.jf.xuan.api")
@SpringBootApplication
public class XuanApplication {

    private static final Logger LOG = LoggerFactory.getLogger(XuanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XuanApplication.class, args);
        LOG.info(" | -- * -- * -- * -- * -- * -- * -- * -- * -- * -- | ");
        LOG.info(" |             Xuan successful startup             | ");
        LOG.info(" | -- * -- * -- * -- * -- * -- * -- * -- * -- * -- | ");
    }
}
