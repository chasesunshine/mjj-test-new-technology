package org.wanbang.study.allDesignMode.createMode.prototypeMode;

import org.wanbang.study.allDesignMode.createMode.prototypeMode.design.QuestionBankController;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 14:10
* @version 1.0
*/

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();

        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("⾖⾖", "1000001921051"));
        System.out.println(questionBankController.createPaper("⼤宝", "1000001921987"));
    }
}
