package com.jf.course.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Description: 数据库密码加密工具，生成密文.</p>
 * <p>Copyright: Copyright(c) 2020.</p>
 * <p>Company: Sefonsoft.</p>
 * <p>CreateTime: 2018/12/4.</p>
 *
 * @author Junfeng
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptPasswordUtil {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("Sevp18x!");
        System.out.println("====================================================");
        System.out.println("Ciphertext: " + result);
        System.out.println("====================================================");
    }
}
