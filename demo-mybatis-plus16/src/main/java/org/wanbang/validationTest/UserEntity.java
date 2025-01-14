package org.wanbang.validationTest;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.wanbang.validationTest.anno.Name;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserEntity {

    @Pattern(regexp="^[a-zA-Z0-9]{6,}$", message="用户名必须是6位以上的字母或数字")
    private String phoneNum;

    @Name
    private String name;

    @NotNull
    private String id;
}
