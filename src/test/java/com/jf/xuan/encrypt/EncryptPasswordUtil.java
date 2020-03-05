package com.jf.xuan.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 数据库密码加密工具，生成密文
 *
 * @author Junfeng
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptPasswordUtil {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("cdsf119");
        System.out.println("====================================================");
        System.out.println("Ciphertext: " + result);
        System.out.println("====================================================");
    }
    @Test
    public void decryptPwd(){
        String result = stringEncryptor.decrypt("LIZqZP7itPTJuNirbBs4OgJZemgMPFgpc9aeJ0blvbxd7IrOcbBYw8/3dHewwqh7");
        System.out.println("====================================================");
        System.out.println("Ciphertext: " + result);
        System.out.println("====================================================");
    }

    // 加密 使用命令：
    // java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="cdsf119" password=xuan_salt algorithm=PBEWithMD5AndDES
}
