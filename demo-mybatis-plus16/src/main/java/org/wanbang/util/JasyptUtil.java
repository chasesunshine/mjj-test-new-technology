package org.wanbang.util;

import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Jasypt加密工具类
 * @author ppp
 * @date 2023/1/5
 */
@Component
public class JasyptUtil {
    private static final Logger logger = LoggerFactory.getLogger(JasyptUtil.class);
    /**
     * 加密使用密钥，需要在和配置文件中的jasypt.encryptor.password保持一致
     */
    private static final String PRIVATE_KEY = "demo";
    /**
     * BasicTextEncryptor对象初始化使用的算法就是"PBEWithMD5AndDES"
     * 点击进源码构造方法中就可以看到下面的设置
     * this.encryptor.setAlgorithm("PBEWithMD5AndDES");
     */
    private static BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

    static {
        basicTextEncryptor.setPassword(PRIVATE_KEY);
    }
    /**
     * 明文加密
     *
     * @param plaintext 明文
     * @return String
     */
    public static String encrypt(String plaintext) {
        logger.info("明文字符串为：{}", plaintext);
        String ciphertext = basicTextEncryptor.encrypt(plaintext);
        logger.info("密文字符串为：{}", ciphertext);
        return ciphertext;
    }

    /**
     * 解密
     *
     * @param ciphertext 密文
     * @return String
     */
    public static String decrypt(String ciphertext) {
        logger.info("密文字符串为：{}", ciphertext);
        ciphertext = "ENC(" + ciphertext + ")";
        if (PropertyValueEncryptionUtils.isEncryptedValue(ciphertext)) {
            String plaintext = PropertyValueEncryptionUtils.decrypt(ciphertext, basicTextEncryptor);
            logger.info("明文字符串为：{}", plaintext);
            return plaintext;
        }
        logger.error("解密失败！");
        return "";
    }

    public static void main(String[] args) {
        String encrypt = encrypt("root");
        System.out.println(encrypt);
        String test = decrypt(encrypt);
    }
}

