package com.jf.xuan.common.util;

import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 加解密工具类
 * @author SF2121
 */
@SuppressWarnings("restriction")
public class AES128Encrypt {
	/**
	 * Decode password.
	 * 
	 * @param input password
	 * @throws NoSuchAlgorithmException NoSuchAlgorithmException
	 * @throws NoSuchPaddingException NoSuchPaddingException
	 * @throws InvalidKeyException InvalidKeyException
	 * @throws IOException IOException
	 * @throws IllegalBlockSizeException IllegalBlockSizeException
	 * @throws BadPaddingException BadPaddingException
	 * @return password
	 */
	public String decrypt(String input) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IOException,
			IllegalBlockSizeException, BadPaddingException {
		return decrypt(input, createSecretKey());
	}
	
	/**
	 * Decode password.(2012-9-8 zhangyan add,用户自行指定密钥)
	 * 
	 * @param input password
	 * @param keyValue 密文
	 * 
	 * @throws NoSuchAlgorithmException NoSuchAlgorithmException
	 * @throws NoSuchPaddingException NoSuchPaddingException
	 * @throws InvalidKeyException InvalidKeyException
	 * @throws IOException IOException
	 * @throws IllegalBlockSizeException IllegalBlockSizeException
	 * @throws BadPaddingException BadPaddingException
	 * @return password
	 */
	public String decrypt(String input, byte[] keyValue)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException,
			IOException, IllegalBlockSizeException, BadPaddingException {
		SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] data = decoder.decodeBuffer(input);
		byte[] decryptData = cipher.doFinal(data, 0, data.length);

		return new String(decryptData, StandardCharsets.UTF_8);
	}

	/**
	 * Encode password.
	 * 
	 * @param input password
	 * @throws NoSuchAlgorithmException NoSuchAlgorithmException
	 * @throws NoSuchPaddingException NoSuchPaddingException
	 * @throws InvalidKeyException InvalidKeyException
	 * @throws IllegalBlockSizeException IllegalBlockSizeException
	 * @throws BadPaddingException BadPaddingException
	 * @return password
	 */
	public String encrypt(String input) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		return encrypt(input, createSecretKey());
	}

	/**
	 * Encode password.(2012-9-8 zhangyan add,用户自行指定密钥)
	 * 
	 * @param input password
	 * @param keyValue 密钥
	 * 
	 * @throws NoSuchAlgorithmException NoSuchAlgorithmException
	 * @throws NoSuchPaddingException NoSuchPaddingException
	 * @throws InvalidKeyException InvalidKeyException
	 * @throws IllegalBlockSizeException IllegalBlockSizeException
	 * @throws BadPaddingException BadPaddingException
	 * @return password
	 */
	public String encrypt(String input, byte[] keyValue) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bs = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));

		return new sun.misc.BASE64Encoder().encode(bs);
	}

	/**
	 * Create AES-128 encrypt key.
	 * 将AES-128加密的密钥修改为可读的字符串
	 * huawei_cdsf_pass
	 * 
	 * @return AES-128 key
	 */
	public byte[] createSecretKey() {
		return new byte[] { 104, 117, 97, 119, 101, 105, 95, 99, 100, 115, 102,
				95, 112, 97, 115, 115 };
	}

	/**
	 * 方法描述:打成pwd.jar包后执行main方法
	 *
	 *
	 * @param args args
	 * @throws InvalidKeyException  InvalidKeyException
	 * @throws NoSuchAlgorithmException NoSuchAlgorithmException
	 * @throws NoSuchPaddingException NoSuchPaddingException
	 * @throws IllegalBlockSizeException IllegalBlockSizeException
	 * @throws BadPaddingException BadPaddingException
	 * @throws IOException IOException
	 */
	public static void main(String[] args) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException,
			BadPaddingException, IOException {
		AES128Encrypt aes = new AES128Encrypt();
		int i = 3;
		BufferedReader reader;
		do {
			pln("************************************");
			pln("Please input your password:");
			String s = "";
			reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
			s = reader.readLine();
			if (s != null && !"".equals(s.trim())) {
				pln("The AES128 code is:\n" +
						aes.encrypt(s.trim()));
				break;
			}
			pln("You input error data!Only " + --i + " times!");
		} while (i != 0);
		reader.close();
		pln("************************************\nQuit Now!");
	}

	private static void pln(String s) {
		System.out.println(s);
	}
}
