package org.wanbang.antireplay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureUtil {

    /**
     * 生成字符串的MD5哈希值（小写形式）
     * @param input 输入字符串
     * @return 小写的MD5哈希值，如果发生错误则返回null
     */
    public static String md5(String input) {
        if (input == null) {
            return null;
        }

        try {
            // 获取MD5消息摘要实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算哈希值
            byte[] hashBytes = md.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString().toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            // MD5算法应该总是可用，但为了安全起见处理这个异常
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

}