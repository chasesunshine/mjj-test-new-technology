package org.wanbang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.Inventoryquestion.entity.InventorySegment;
import org.wanbang.Inventoryquestion.mapper.InventorySegmentMapper;
import org.wanbang.Inventoryquestion.service.InventoryService;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventorySegmentMapper segmentMapper;

    private Long testProductId = 1L;

    @Test
    public void setup() {
        // 初始化测试商品库存
        inventoryService.initInventory(testProductId, 1000);
    }

    @Test
    public void TestData(){
        System.out.println("123");
    }

    @Test
    public void testConcurrentInventoryReduction() throws InterruptedException {
        int threadCount = 100;
        int reducePerThread = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    inventoryService.reduceInventory(testProductId, reducePerThread);
                } catch (Exception e) {
                    System.out.println("库存扣减失败: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();

        // 验证总库存是否正确
        List<InventorySegment> segments = segmentMapper.selectList(
                new LambdaQueryWrapper<InventorySegment>()
                        .eq(InventorySegment::getProductId, testProductId)
        );

        int remainingStock = segments.stream().mapToInt(InventorySegment::getStock).sum();
        assertEquals(0, remainingStock, "最终库存应为0");
    }
}
