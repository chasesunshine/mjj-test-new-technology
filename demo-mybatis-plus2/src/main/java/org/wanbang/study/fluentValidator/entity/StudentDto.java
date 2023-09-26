package org.wanbang.study.fluentValidator.entity;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/14 15:47
* @version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :jianyul
 * @date : 2022/5/16 18:00
 */
@Data
@AllArgsConstructor
public class StudentDto {

    private String name;

    private Integer age;

    private String schoolName;

    private String area;
}