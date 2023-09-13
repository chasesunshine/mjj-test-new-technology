package org.dongfu.study.allDesignMode.createMode.prototypeMode.entity;

import lombok.Data;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 14:14
* @version 1.0
*/
@Data
public class ChoiceQuestion {
    private String name; // 题⽬
    private Map<String, String> option; // 选项；A、B、C、D
    private String key; // 答案；B

    public ChoiceQuestion() {
    }
    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }
    // ...get/set
}
