package org.dongfu.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongfu.entity.User;

import javax.validation.constraints.NotBlank;

/**
* @description: TODO
* @author majiajian
* @date 2022/11/23 14:35
* @version 1.0
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResp {
    private static final long serialVersionUID = -83513220652821879L;

    private Long id;

    private Integer age;

    private String name;

    private String sex;

    private Integer value;

    private User user;
}
