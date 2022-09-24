package org.wanbang.study.ioc.ioc05.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/24 16:24
 * @version 1.0
 */

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();
    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

