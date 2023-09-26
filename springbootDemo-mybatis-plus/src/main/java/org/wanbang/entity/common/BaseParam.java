package org.wanbang.entity.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BaseParam {
    /**
     * 当前页
     */
    @TableField(exist = false)
    private Integer current = 1;

    /**
     * 页大小
     */
    @TableField(exist = false)
    private Integer size = 10;

    @TableField(fill = FieldFill.INSERT)
    private String orgId;
}
