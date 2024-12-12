package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * (SpringWord)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:17:38
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;

    @TableField(exist = false)
    @TableId(type = IdType.ASSIGN_ID) // 或者 IdType.INPUT 如果你想自己赋值
    private Long id; // 这个字段在数据库表中可能并不存在

    @TableField("age")
    private Integer age;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("sex")
    private String sex;
}

