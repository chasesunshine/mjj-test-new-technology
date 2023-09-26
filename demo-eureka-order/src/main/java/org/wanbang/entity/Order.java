package org.wanbang.entity;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:44
* @version 1.0
*/

import org.wanbang.rpc.entity.Item;
import java.util.List;

public class Order {
    private Long orderId;

    private List<Item> itemList;

    public Order(long orderId, List<Item> itemList) {
        this.orderId = orderId;
        this.itemList = itemList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}