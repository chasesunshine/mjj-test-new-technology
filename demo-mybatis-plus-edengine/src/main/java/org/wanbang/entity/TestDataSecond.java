package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SpringWord)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:17:38
 */
@Data
@TableName("test_data")
public class TestDataSecond implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;

    @TableField(value = "ts")
    private Date ts;

    @TableField(value = "speed")
    private Integer speed;
}

