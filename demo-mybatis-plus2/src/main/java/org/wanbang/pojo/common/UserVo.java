package org.wanbang.pojo.common;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)	//链式设置属性
@TableName(value="user")
public class UserVo {
    private String name1;
    private Integer age1;
    private String sex1;

}
