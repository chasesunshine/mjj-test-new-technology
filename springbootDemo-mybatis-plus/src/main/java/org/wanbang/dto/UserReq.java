package org.wanbang.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.wanbang.util.anno.Odd;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserReq implements Serializable {

    @Odd
    private Integer age;

    private String name;
    private String sex;

}
