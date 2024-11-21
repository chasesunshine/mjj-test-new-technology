package org.wanbang.study.ConditionAnno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private String name;

    private Integer age;
}
