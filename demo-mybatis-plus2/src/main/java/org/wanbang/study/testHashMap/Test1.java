package org.wanbang.study.testHashMap;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/8 16:30
* @version 1.0
*/

public class Test1 {
    public Map<String ,String > value1 = new HashMap<>();

    public void putValue(){
        value1.put("1","1");
        value1.put("2","2");
        value1.put("3","3");
    }

    public Map getValue(){
        return value1;
    }

    public void changeValue(String key,String value){
        value1.put(key,value);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.putValue();
        test1.changeValue("1","11");
        Map getvalue = test1.getValue();
        System.out.println(JSON.toJSONString(getvalue));

        Test1 test2 = new Test1();
        Map getvalue1 = test2.getValue();
        System.out.println(JSON.toJSONString(getvalue1));
    }
}
