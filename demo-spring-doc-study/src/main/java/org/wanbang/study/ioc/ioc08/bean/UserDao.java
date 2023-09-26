package org.wanbang.study.ioc.ioc08.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/24 16:24
 * @version 1.0
 */

/**
 *
 *  UserDao，修改了之前使用 static 静态块初始化数据的方式，改为提供
 * initDataMethod 和 destroyDataMethod 两个更优雅的操作方式进行处理。
 *
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod() {

        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

