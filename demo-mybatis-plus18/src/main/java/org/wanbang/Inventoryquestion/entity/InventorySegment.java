package org.wanbang.Inventoryquestion.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("inventory_segment")
public class InventorySegment {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    // 商品ID
    private Long productId;
    
    // 分段编号
    private Integer segmentNo;
    
    // 分段库存数量
    private Integer stock;
    
    // 版本号，用于乐观锁
    private Integer version;
}