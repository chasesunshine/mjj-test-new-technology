package org.dongfu.study.allDesignMode.createMode.prototypeMode.util;

import lombok.Data;

import java.util.*;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/11 14:10
 * @version 1.0
 */

@Data
public class Topic {
    private Map<String, String> option;
    private String key;

    public Topic(HashMap<String, String> optionNew, String keyNew) {
        this.option = optionNew;
        this.key = keyNew;
    }

}
