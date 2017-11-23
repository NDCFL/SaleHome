package com.ht.pluspassword;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 字符串加密解密类
 * 
 * @author 
 * */
public class AesUtils {

	public static final String SECRETKEY = "secretKey";

	public static void main(String[] args) throws Exception {
		String strTestData = "明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456";
		strTestData += "明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456";
		strTestData += "明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456明文123456";

		// 加密
//		String encryptResultStr = encryptStr(strTestData, SECRETKEY);
//		System.out.println("加密后：" + encryptResultStr);
		// 解密
		String decryptResultStr = decryptStr("6F0D9AC9F81D05E2618F64944F745EA4", SECRETKEY);
		System.out.println("解密后：" + decryptResultStr);

	}

	/**
	 * 字符串加密
	 * 
	 * @param srcStr
	 *            加密字符串
	 * @param password
	 *            加密密钥
	 * */
	public static String encryptStr(String srcStr, String password) {
		byte[] encryptResult = encryptData_AES(srcStr, password);
		String encryptResultStr = parseByte2HexStr(encryptResult);
		return encryptResultStr;
	}

	/**
	 * 字符串解密
	 * 
	 * @param srcStr
	 *            解密字符串
	 * @param password
	 *            加密密钥
	 * */
	public static String decryptStr(String srcStr, String password) {
		String returnValue = "";
		try {
			byte[] decryptFrom = parseHexStr2Byte(srcStr);
			byte[] decryptResult = decryptData_AES(decryptFrom, password);
			returnValue = new String(decryptResult, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	private static byte[] encryptData_AES(String content, String password) {
		try {
			SecretKey secretKey = getKey(password);
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 生成指定字符串的密钥
	 * 
	 * @param secret
	 *            要生成密钥的字符
	 * @return secretKey 生成后的密钥
	 * @throws GeneralSecurityException
	 */
	private static SecretKey getKey(String secret) throws GeneralSecurityException {
		try {           
	          KeyGenerator _generator = KeyGenerator.getInstance("AES");  
	          SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
	          secureRandom.setSeed(secret.getBytes());  
	          _generator.init(128,secureRandom);  
	          return _generator.generateKey();  
	      }  catch (Exception e) {  
	           throw new RuntimeException("初始化密钥出现异常");  
	      }  
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	private static byte[] decryptData_AES(byte[] content, String password) {
		try {
			SecretKey secretKey = getKey(password);
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}