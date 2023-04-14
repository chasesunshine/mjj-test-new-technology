package org.dongfu.service;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:43
* @version 1.0
*/

import org.dongfu.entity.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {
    private static final Map<Long, Item> ITEM_MAP = new HashMap<Long, Item>();

    static {// 准备一些静态数据,模拟数据库
        ITEM_MAP.put(1L, new Item(1L, "《百年孤独》",  20d));
        ITEM_MAP.put(2L, new Item(2L, "《我的名字叫红》",  30d));
        ITEM_MAP.put(3L, new Item(3L, "《不能承受的生命之轻》",  40d));
        ITEM_MAP.put(4L, new Item(4L, "《跳房子》",  50d));
        ITEM_MAP.put(5L, new Item(5L, "《佩德罗 巴勒莫》",  60d));
    }

    /**
     * 模拟实现商品查询
     *
     * @param id
     * @return
     */
    public Item queryItemById(Long id) {
        return ITEM_MAP.get(id);
    }

}