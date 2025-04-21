package org.wanbang.Inventoryquestion.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.Inventoryquestion.util.DistributedLockService;
import org.wanbang.Inventoryquestion.entity.InventorySegment;
import org.wanbang.Inventoryquestion.mapper.InventorySegmentMapper;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    private static final int SEGMENT_COUNT = 10; // 库存分段数量

    @Autowired
    private InventorySegmentMapper segmentMapper;

    @Autowired
    private DistributedLockService lockService;

    @Override
    @Transactional
    public boolean reduceInventory(Long productId, int quantity) {
        // 1. 获取商品所有库存分段
        List<InventorySegment> segments = segmentMapper.selectList(new LambdaQueryWrapper<InventorySegment>()
                        .eq(InventorySegment::getProductId, productId)
                        .orderByAsc(InventorySegment::getSegmentNo));

        if (segments.isEmpty()) {
            throw new RuntimeException("商品库存不存在");
        }

        int remaining = quantity;

        // 2. 尝试从各个分段扣减库存
        for (InventorySegment segment : segments) {
            if (remaining <= 0) break;

            String lockKey = "inventory:lock:" + productId + ":" + segment.getSegmentNo();

            try {
                // 获取分布式锁
                if (!lockService.tryLock(lockKey, 3, 10)) {
                    System.out.println("获取分布式锁失败: "+lockKey);
                    continue; // 获取锁失败，尝试下一个分段
                }

                // 检查分段库存是否足够
                if (segment.getStock() > 0) {
                    int deduct = Math.min(remaining, segment.getStock());

                    // 乐观锁更新库存
                    int updated = segmentMapper.reduceStock(segment.getId(), deduct, segment.getVersion());

                    if (updated > 0) {
                        remaining -= deduct;
                        segment.setStock(segment.getStock() - deduct);
                        segment.setVersion(segment.getVersion() + 1);
                    }
                }
            } finally {
                // 释放锁
                lockService.unlock(lockKey);
            }
        }

        if (remaining > 0) {
            throw new RuntimeException("库存不足");
        }

        return true;
    }

    @Override
    public void initInventory(Long productId, int totalStock) {
        // 删除旧的分段
        segmentMapper.delete(new LambdaQueryWrapper<InventorySegment>().eq(InventorySegment::getProductId, productId)
        );

        // 计算每个分段的库存
        int baseStock = totalStock / SEGMENT_COUNT;
        int remainder = totalStock % SEGMENT_COUNT;

        // 创建新的分段
        for (int i = 0; i < SEGMENT_COUNT; i++) {
            InventorySegment segment = new InventorySegment();
            segment.setProductId(productId);
            segment.setSegmentNo(i);
            segment.setStock(i < remainder ? baseStock + 1 : baseStock);
            segment.setVersion(0);
            segmentMapper.insert(segment);
        }
    }
}
