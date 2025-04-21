package org.wanbang.Inventoryquestion.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.wanbang.Inventoryquestion.entity.InventorySegment;

@Mapper
public interface InventorySegmentMapper extends BaseMapper<InventorySegment> {

    int reduceStock(@Param("id") Long id, @Param("deduct") int deduct, @Param("version") int version);
}
