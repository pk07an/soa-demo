package com.meila.soa.proxy.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;



/**
 * 
 ************************************************************
 * @类名 : AesUtils.java
 *
 * @DESCRIPTION : AES加解密相关工具类
 * @AUTHOR :  abner
 * @DATE :  2016年1月6日
 ************************************************************
 */
public class AesUtils {
    /**
     * 
     *
     * 功能描述：对字符串进行AES加密
     * 
     * @param content 待加密的内容
     * @param passwd 加密密码
     * @param charset 编码格式
     * @return byte[]  加密后的byte数组
     *
     */
    public static byte[] encrypt(String content,String passwd,String charset) throws Exception{
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(passwd.getBytes(charset)));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        
        Cipher cipher = Cipher.getInstance("AES");
        byte[] byteContent = content.getBytes(charset);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        
        byte[] result = cipher.doFinal(byteContent); //加密
        return result;
    }
    
    /**
     * 
     *
     * 功能描述：对输入数组进行AES解密
     * 
     * @param content 带解密数据
     * @param password 解密密码
     * @param charset 字符集
     * @return
     * @throws Exception byte[]
     *
     */
    public static byte[] decrypt(byte[] content,String password,String charset) throws Exception{
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(password.getBytes(charset)));  
        SecretKey secretKey = kgen.generateKey();  
        byte[] enCodeFormat = secretKey.getEncoded();  
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
        byte[] result = cipher.doFinal(content);  
        return result; 
    }
    
    /**
     * 
     *
     * 功能描述：将byte数组转换为String
     * 
     * @param buf
     * @return String
     *
     */
    public static String parseByte2HexStr(byte buf[]) {  
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
     * 
     *
     * 功能描述：将十六进制转换为二进制
     * 
     * @param hexStr
     * @return byte[]
     *
     */
    public static byte[] parseHexStr2Byte(String hexStr) {  
        if (hexStr.length() < 1)  
                return null;  
        byte[] result = new byte[hexStr.length()/2];  
        for (int i = 0;i< hexStr.length()/2; i++) {  
                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
                result[i] = (byte) (high * 16 + low);  
        }  
        return result;  
    }  
    
    /**
     * 
     *
     * 功能描述：将Base64转换为byte数组
     * 
     * @param str
     * @return byte[]
     *
     */
    public static byte[] decodeBase64(String str){
        return Base64Utils.decodeFromString(str);
    }
    
    /**
     * 
     *
     * 功能描述：将byte数组转为base64
     * 
     * @param bytes
     * @return String
     *
     */
    public static String encodeBase64(final byte[] bytes){
        return new String(Base64Utils.encodeToString(bytes));
    }
    
    /**
     * 
     *
     * 功能描述：AES加密并用base64转码
     * 
     * @param str
     * @param key
     * @return
     * @throws Exception String
     *
     */
    public static String aesEncryptAndBase64(String str, String key ,String charset) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(charset), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return Base64Utils.encodeToString(bytes);
    }
    
    /**
     * 
     *
     * 功能描述：base64转码后用aes解密
     * 
     * @param str
     * @param key
     * @return
     * @throws Exception String
     *
     */
    public static String aesBase64Decrypt(String str, String key,String charset) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(charset), "AES"));
        byte[] bytes = Base64Utils.decodeFromString(str);
        bytes = cipher.doFinal(bytes);
        return new String(bytes, "utf-8");
    }

}
