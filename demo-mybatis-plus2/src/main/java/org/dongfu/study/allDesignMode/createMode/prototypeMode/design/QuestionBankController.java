package org.dongfu.study.allDesignMode.createMode.prototypeMode.design;

import org.dongfu.study.allDesignMode.createMode.prototypeMode.entity.AnswerQuestion;
import org.dongfu.study.allDesignMode.createMode.prototypeMode.entity.ChoiceQuestion;
import org.dongfu.study.allDesignMode.createMode.prototypeMode.core.QuestionBank;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/11 14:09
 * @version 1.0
 */

/**
 * 初始化试卷数据
 *
 * 这个类的内容就⽐较简单了，主要提供对试卷内容的模式初始化操作(所有考⽣试卷⼀样，题⽬顺
 * 序不⼀致)。
 * 以及对外部提供创建试卷的⽅法，在创建的过程中使⽤的是克隆的⽅式； (QuestionBank)
 * questionBank.clone(); ，并最终返回试卷信息。
 */
public class QuestionBankController {
    private QuestionBank questionBank = new QuestionBank();

    public QuestionBankController() {
        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");

        Map<String, String> map02 = new HashMap<String, String>();
        map02.put("A", "JAVA程序的main⽅法必须写在类⾥⾯");
        map02.put("B", "JAVA程序中可以有多个main⽅法");
        map02.put("C", "JAVA程序中类名必须与⽂件名⼀样");
        map02.put("D", "JAVA程序的main⽅法中如果只有⼀条语句，可以不⽤{}(⼤括号)括起来");

        Map<String, String> map03 = new HashMap<String, String>();
        map03.put("A", "变量由字⺟、下划线、数字、$符号随意组成；");
        map03.put("B", "变量不能以数字作为开头；");
        map03.put("C", "A和a在java中是同⼀个变量；");
        map03.put("D", "不同类型的变量，可以起相同的名字；");

        Map<String, String> map04 = new HashMap<String, String>();
        map04.put("A", "STRING");
        map04.put("B", "x3x;");
        map04.put("C", "void");
        map04.put("D", "de$f");

        Map<String, String> map05 = new HashMap<String, String>();
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        questionBank.append(new ChoiceQuestion("JAVA所定义的版本中不包括", map01, "D"))
                .append(new ChoiceQuestion("下列说法正确的是", map02, "A"))
                .append(new ChoiceQuestion("变量命名规范说法正确的是", map03, "B"))
                .append(new ChoiceQuestion("以下()不是合法的标识符",map04, "C"))
                .append(new ChoiceQuestion("表达式(11+3*8)/4%3的值是", map05, "D"))
                .append(new AnswerQuestion("⼩红⻢和⼩⿊⻢⽣的⼩⻢⼏条腿", "4条腿"))
                .append(new AnswerQuestion("铁棒打头疼还是⽊棒打头疼", "头最疼"))
                .append(new AnswerQuestion("什么床不能睡觉", "⽛床"))
                .append(new AnswerQuestion("为什么好⻢不吃回头草", "后⾯的草没了"));
    }

    public String createPaper(String candidate, String number) throws CloneNotSupportedException {
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);

        return questionBankClone.toString();
    }

}