package org.wanbang.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.wanbang.util.anno.Odd;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserReq implements Serializable {

    @Odd
    private Integer age;

    @NotEmpty(message = "名字不能为空")
    private String name;

    @NotEmpty
    private String sex;

    @NotNull
    private Integer number;

}
