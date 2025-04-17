package org.wanbang.Inventoryquestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.Inventoryquestion.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/reduce")
    public ResponseEntity<String> reduceInventory(@RequestParam Long productId, @RequestParam int quantity) {
        try {
            boolean success = inventoryService.reduceInventory(productId, quantity);
            if (success) {
                return ResponseEntity.ok("库存扣减成功");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("库存不足");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("库存扣减失败: " + e.getMessage());
        }
    }

    @PostMapping("/init")
    public ResponseEntity<String> initInventory(@RequestParam Long productId, @RequestParam int totalStock) {
        inventoryService.initInventory(productId, totalStock);
        return ResponseEntity.ok("库存初始化成功");
    }
}
