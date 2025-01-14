package org.wanbang.param;

import lombok.*;
import lombok.experimental.Accessors;

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
@Builder
@Accessors(chain = true)
public class RequestParam implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;

    private String group;


    private Integer id; // 这个字段在数据库表中可能并不存在

    private Integer age;

    private String name;

    private String password;

    private String sex;
}

