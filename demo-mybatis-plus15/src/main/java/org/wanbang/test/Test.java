package org.wanbang.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public interface Test2{
        public String info();
    }

//    public static void main(String[] args) {
//        Test2 test2 = new Test2() {
//            @Override
//            public String info() {
//                return "ceshi";
//            }
//        };
//    }


    /**
     * 当你使用 JSON.toJSONString() 方法将包含循环引用或重复对象的复杂数据结构（例如嵌套的 Map<String, Map<String, Object>>）序列化为 JSON 字符串时，
     * FastJSON 可能会优化输出，以避免重复序列化相同的对象。它通过使用 $ref 关键字来引用已经序列化过的对象的位置，从而实现这一点。
     *
     * 运行上述代码时，innerMap 对象被放置到了 outerMap 中，然后又把自己作为值放入了自己的 self 键下。
     * 这会导致 FastJSON 在序列化过程中识别出 innerMap 的循环引用，并且会在第二个出现的地方用 $ref 来表示对第一个实例的引用，而不是再次完整地序列化 innerMap。
     *
     * 注意：如果你不希望 FastJSON 使用 $ref，你可以设置 SerializerFeature.DisableCircularReferenceDetect 特性来禁用循环引用检测。
     * 但是这样做可能会导致无限递归的问题，如果确实存在循环引用的话。所以你需要根据你的实际情况来决定是否使用这个特性。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个外部 map
        Map<String, Object> outerMap = new HashMap<>();
        // 创建一个内部 map
        Map<String, Object> innerMap = new HashMap<>();

        // 将内部 map 放入外部 map 中
        outerMap.put("inner", innerMap);
        // 再次将内部 map 放入自身中，形成循环引用
        innerMap.put("self", innerMap);

        // 序列化为 JSON 字符串，并启用 PrettyFormat 使输出更易读
        String jsonString = JSON.toJSONString(outerMap);

        // 打印 JSON 字符串
        System.out.println(jsonString);
    }
}
