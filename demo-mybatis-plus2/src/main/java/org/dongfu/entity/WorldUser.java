package org.dongfu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TableName("world_user")
@Builder
public class WorldUser implements Serializable {

    private long id;

    private Integer age;

    private String name;

    private String sex;
}

