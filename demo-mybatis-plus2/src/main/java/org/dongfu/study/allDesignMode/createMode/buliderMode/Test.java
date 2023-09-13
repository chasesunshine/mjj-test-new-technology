package org.dongfu.study.allDesignMode.createMode.buliderMode;

import org.dongfu.study.allDesignMode.createMode.buliderMode.design.Builder;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 13:36
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢⽥园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}
