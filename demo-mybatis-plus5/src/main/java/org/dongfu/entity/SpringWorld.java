package org.dongfu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.validation.constraints.NotBlank;
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
@TableName("spring_world")
@Builder
public class SpringWorld implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;
    
    private Long id;
    
    private Integer age;

    @NotBlank(message = "名字不能为空")
    private String name;
    
    private String sex;
}

