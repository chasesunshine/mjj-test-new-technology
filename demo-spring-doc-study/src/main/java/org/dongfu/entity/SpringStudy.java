package org.dongfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * (SpringStudy)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:17:38
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TableName("spring_study")
@Builder
public class SpringStudy implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;
    
    private Long id;
    
    private Integer age;
    
    private String name;
    
    private String sex;

}

