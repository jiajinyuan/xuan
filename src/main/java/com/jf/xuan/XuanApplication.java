package com.jf.xuan;

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

    public static void main(String[] args) {
        SpringApplication.run(XuanApplication.class, args);
    }
}
