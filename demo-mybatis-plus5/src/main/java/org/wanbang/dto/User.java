package org.wanbang.dto;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/23 11:34
* @version 1.0
*/
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private Integer age;
}
