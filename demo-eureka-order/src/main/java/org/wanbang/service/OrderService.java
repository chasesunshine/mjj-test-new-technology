package org.wanbang.service;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:43
* @version 1.0
*/

import org.wanbang.entity.Order;
import org.wanbang.rpc.entity.Item;
import org.wanbang.rpc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private static final Map<String, Order> ORDER_DATA = new HashMap<String, Order>();

    static {
        // 模拟数据库，构造测试数据
        List<Item> itemList = new ArrayList<Item>();
        Item item = new Item();// 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
        item.setId(1L);
        itemList.add(item);
        item = new Item();
        item.setId(2L);
        itemList.add(item);

        Order order = new Order(20190831L,itemList);

        ORDER_DATA.put(order.getOrderId().toString(), order);
    }

    @Autowired
    private ItemService itemService;

    /**
     * 根据订单id查询订单数据
     *
     * @param orderId
     * @return
     */
    public Order queryOrderById(String orderId) {
        Order order = ORDER_DATA.get(orderId);
        if (null == order) {
            return null;
        }
        List<Item> itemList = order.getItemList();
        List<Item> itemListWithDetail = new LinkedList<>();
        for (Item item : itemList) {
            // 通过商品微服务查询商品详细数据
            Item itemWithDetail = itemService.queryItemById(item.getId());
            itemListWithDetail.add(itemWithDetail);
        }
        order.setItemList(itemListWithDetail);
        return order;
    }
}