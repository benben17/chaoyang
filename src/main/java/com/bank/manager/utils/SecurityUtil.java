package com.bank.manager.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 加密工具
 */
public class SecurityUtil {

    private static Logger log = LoggerFactory.getLogger(SecurityUtil.class);
    private static final String MD5 = "MD5";
    private static final String CHARSET = "utf-8";
    private static char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F'};

    /**
     * MD5摘要算法
     *
     * @param content 摘要内容
     */
    public static String md5(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(MD5);
            // 使用指定的字节更新摘要
            digest.update(content.getBytes(CHARSET));
            // 获得密文
            byte[] md = digest.digest();

            return byteToHexString(md);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignored) {
            return "";
        }
    }

    /**
     * 把密文转换成十六进制的字符串形式
     */
    private static String byteToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(byteToHexString(b));
        }

        return sb.toString();
    }

    private static String byteToHexString(byte ib) {
        char[] ob = new char[2];
        ob[0] = HEX_DIGITS[(ib >>> 4) & 0X0f];
        ob[1] = HEX_DIGITS[ib & 0X0F];
        return new String(ob);
    }



    public static String LdapEncoderMd5(String psw) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            String md5psw = base64en.encode(md5.digest(psw.getBytes("utf-8")));

            return "{MD5}" + md5psw;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignored) {
            return "";
        }

    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
