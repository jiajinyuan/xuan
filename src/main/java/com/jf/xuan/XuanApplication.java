package com.jf.xuan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>Description: Application .</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/3.</p>
 *
 * @author Junfeng
 */
@SpringBootApplication
@MapperScan("com.jf.xuan.api")
@EnableCaching
public class XuanApplication {

    private static final Logger LOG = LoggerFactory.getLogger(XuanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XuanApplication.class, args);
        String sb = "\n   _____ _             _                                      __       _ \n" +
                "  / ____| |           | |                                    / _|     | |\n" +
                " | (___ | |_ __ _ _ __| |_   ___ _   _  ___ ___ ___  ___ ___| |_ _   _| |\n" +
                "  \\___ \\| __/ _` | '__| __| / __| | | |/ __/ __/ _ \\/ __/ __|  _| | | | |\n" +
                "  ____) | || (_| | |  | |_  \\__ \\ |_| | (_| (_|  __/\\__ \\__ \\ | | |_| | |\n" +
                " |_____/ \\__\\__,_|_|   \\__| |___/\\__,_|\\___\\___\\___||___/___/_|  \\__,_|_|\n";
        LOG.info(sb);
    }
}
