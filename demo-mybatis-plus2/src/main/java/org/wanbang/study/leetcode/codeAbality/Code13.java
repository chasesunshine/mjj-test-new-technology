package org.wanbang.study.leetcode.codeAbality;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/9 18:22
* @version 1.0
*/

public class Code13 {
    static Map template = new HashMap<String,Long>();
    static Map finalValueIndex = new HashMap<Long,Long>();

    public static void main(String[] args) {
        long sum = 0;
        setValue();
        String testValue = "MCMXCIV";
        for (int i = 0; i < testValue.length(); i++) {
            String substring = testValue.substring(i, i + 1);
            Long value = Long.parseLong(template.get(substring).toString());
            Long xxx =  (long)i;
            finalValueIndex.put(xxx,value);
        }

        Iterator <Map.Entry< Long, Long >> iterator = finalValueIndex.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Long, Long> entry = iterator.next();
            Long key = entry.getKey();
            Long value = entry.getValue();
            double pow = Math.pow(10, key);
            long s = new Double(pow).longValue();
            sum = sum + value * s;
        }
        System.out.println(sum);

    }

    private static void setValue() {
        template.put("I", 1);
        template.put("V", 5);
        template.put("X", 10);
        template.put("L", 50);
        template.put("C", 100);
        template.put("D", 500);
        template.put("M", 1000);
    }
}
