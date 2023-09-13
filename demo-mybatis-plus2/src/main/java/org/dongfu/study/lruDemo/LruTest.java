package org.dongfu.study.lruDemo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruTest<K,V> extends LinkedHashMap<K,V> {

    private int size;

    public LruTest(int initialCapacity,float loadFactor,boolean accessOrder){
        super(initialCapacity,loadFactor,accessOrder);
        this.size = initialCapacity;
    }

    /**
     * 重写LinkedHashMap的removeEldestEntry方法
     * 当LRU元素超过容量上限size后，删除最不经常使用的
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }



    public static void main(String[] args) {
        // 从下面源码中，我们可以看到，通过accessOrder如果为true，则按照访问顺序进行排序，将访问到的数据放置链表尾部，如果为false，则按插入顺序进行排序
        LruTest<String,String> linkedHashMap = new LruTest<>(5,0.75f,true);

        linkedHashMap.put("3","3");
        linkedHashMap.put("4","4");
        linkedHashMap.put("1","1");
        linkedHashMap.put("5","5");
        linkedHashMap.put("6","6");

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey());
        }

        System.out.println("=========get(1)后将1移动到尾部=========");

        linkedHashMap.get("1");

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey());
        }

        System.out.println("=========插入新数据后，移除头部最老的3和4=========");

        linkedHashMap.put("2","2");
        linkedHashMap.put("9","9");

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey());
        }
    }


}