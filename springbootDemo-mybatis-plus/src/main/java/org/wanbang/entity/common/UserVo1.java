package org.wanbang.entity.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)	//链式设置属性
public class UserVo1 {

    private String name;
    private Integer age;
    private String sex;
    
}
