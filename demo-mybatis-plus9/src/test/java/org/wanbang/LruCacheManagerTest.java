package org.wanbang;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.lru.LruCacheManager;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class LruCacheManagerTest {

    @Autowired
    private LruCacheManager lruCacheManager;

    @Test
    public void testLruCache() throws InterruptedException {
        lruCacheManager.put("key1", "value1");
        lruCacheManager.put("key2", "value2");
        lruCacheManager.put("key3", "value3");

        assertEquals("value1", lruCacheManager.get("key1"));

        // 模拟时间流逝
        Thread.sleep(1000);

        // 插入新的键值对，触发LRU清理
        for (int i = 4; i <= 105; i++) {
            lruCacheManager.put("key" + i, "value" + i);
        }

        // 检查最旧的键是否被清理
        assertNull(lruCacheManager.get("key1"));
        assertEquals("value2", lruCacheManager.get("key2"));
        assertEquals("value3", lruCacheManager.get("key3"));
        assertEquals("value105", lruCacheManager.get("key105"));
    }

    @Test
    public void testLruCache1(){
        // 插入新的键值对，触发LRU清理
        for (int i = 0; i <= 105; i++) {
            lruCacheManager.put("key" + i, "value" + i);
        }
        Set<String> value = lruCacheManager.getValue();
        System.out.println(JSON.toJSONString(value));
    }
}
