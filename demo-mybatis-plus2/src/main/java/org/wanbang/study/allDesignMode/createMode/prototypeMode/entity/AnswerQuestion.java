package org.wanbang.study.allDesignMode.createMode.prototypeMode.entity;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 14:15
* @version 1.0
*/

@Data
public class AnswerQuestion {
    private String name; // 问题
    private String key; // 答案
    public AnswerQuestion() {
    }
    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }
    // ...get/set
}
