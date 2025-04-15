package org.wanbang.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
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
    
    private Long id;

    @ExcelProperty(value = "年龄",index = 1)
    @TableField("age")
    private Integer age;

    @ExcelProperty(value = "姓名",index = 0)
    @TableField("name")
    private String name;

    private String password;
    
    private String sex;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

