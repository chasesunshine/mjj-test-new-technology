package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * (SpringWord)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:17:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;
    
    private Long id;
    
    private Integer age;

    private String name;

    private String password;
    
    private String sex;
}

