package org.wanbang.entity.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)	//链式设置属性
public class UserVo extends BaseParam{
    private String name1;
    private Integer age1;
    private String sex1;

}
