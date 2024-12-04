package org.wanbang.testlvmi;

import java.security.SecureRandom;

/**
 * @description
 * @author 马佳健
 * @date 19:49 2024/12/3
 **/
public class TimestampedRandomStringGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int RANDOM_PART_LENGTH = 10;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        long timestamp = System.currentTimeMillis();
        // 取前6位作为时间戳部分
        String tsPart = Long.toHexString(timestamp).substring(0, 6);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RANDOM_PART_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        // 拼接时间戳和随机字符部分
        return tsPart + sb.toString();
    }
}
