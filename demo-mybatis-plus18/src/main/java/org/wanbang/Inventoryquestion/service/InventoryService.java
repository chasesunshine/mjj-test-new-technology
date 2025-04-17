package org.wanbang.Inventoryquestion.service;

public interface InventoryService {

    boolean reduceInventory(Long productId, int quantity);

    void initInventory(Long productId, int totalStock);
}
