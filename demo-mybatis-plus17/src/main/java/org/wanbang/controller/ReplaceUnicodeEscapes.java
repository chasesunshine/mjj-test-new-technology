package org.wanbang.controller;

import org.json.JSONObject;

public class ReplaceUnicodeEscapes {
//    public static void main(String[] args) {
//        // 示例 JSONObject
//        String jsonString = "{\"name\":\"John\u0020Doe\",\"message\":\"Hello\u0000World\"}";
//        JSONObject jsonObject = new JSONObject(jsonString);
//
//        // 遍历并替换
//        replaceUnicodeInJsonObject(jsonObject);
//
//        // 输出结果
//        System.out.println(jsonObject.toString(4));
//    }

//    private static void replaceUnicodeInJsonObject(JSONObject jsonObject) {
//        for (String key : jsonObject.keySet()) {
//            Object value = jsonObject.get(key);
//            if (value instanceof String) {
//                String strValue = (String) value;
//
//                strValue = strValue.replaceAll("\\\\u([0-9a-fA-F]{4})", match -> {
//
//
//                    // 将匹配到的Unicode编码转换为字符
//                    int codePoint = Integer.parseInt(match.group(1), 16);
//                    return Character.toString((char)codePoint);
//                });
//
//                // 更新 JSONObject 中的值
//                jsonObject.put(key, strValue);
//            } else if (value instanceof JSONObject) {
//                // 递归调用以处理嵌套的 JSONObject
//                replaceUnicodeInJsonObject((JSONObject) value);
//            }
//        }
//    }
}