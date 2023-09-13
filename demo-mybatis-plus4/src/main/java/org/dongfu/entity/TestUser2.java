package org.dongfu.entity;

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
@TableName("test_user2")
@Builder
public class TestUser2 implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;
    
    private Long id;
    
    private Integer age;
    
    private String name;
    
    private String sex;

}

