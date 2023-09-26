package org.wanbang.study.allDesignMode.createMode.prototypeMode.core;

import org.wanbang.study.allDesignMode.createMode.prototypeMode.entity.AnswerQuestion;
import org.wanbang.study.allDesignMode.createMode.prototypeMode.entity.ChoiceQuestion;
import org.wanbang.study.allDesignMode.createMode.prototypeMode.util.Topic;
import org.wanbang.study.allDesignMode.createMode.prototypeMode.util.TopicRandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/11 14:13
 * @version 1.0
 */

/**
 * 克隆对象处理类
 *
 * 这⾥的主要操作内容有三个，分别是；
 * 两个 append() ，对各项题⽬的添加，有点像我们在建造者模式中使⽤的⽅式，添加装修物料。
 * clone() ，这⾥的核⼼操作就是对对象的复制，这⾥的复制不只是包括了本身，同时对两个集合
 * 也做了复制。只有这样的拷⻉才能确保在操作克隆对象的时候不影响原对象。
 * 乱序操作，在 list 集合中有⼀个⽅法， Collections.shuffle ，可以将原有集合的顺序打乱，
 * 输出⼀个新的顺序。在这⾥我们使⽤此⽅法对题⽬进⾏乱序操作。
 *
 */
public class QuestionBank implements Cloneable {
    private String candidate; // 考⽣
    private String number; // 考号
    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<ChoiceQuestion>();
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<AnswerQuestion>();

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        choiceQuestionList.add(choiceQuestion);
        return this;
    }
    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestionList.add(answerQuestion);
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();
        // 题⽬乱序
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        // 答案乱序
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());
        }
        return questionBank;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考⽣：" + candidate +
                "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "⼀、选择题" + "\r\n\n");
        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestionList.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");
            }
            detail.append("答案：").append(choiceQuestionList.get(idx).getKey()).append("\r\n\n");
        }
        detail.append("⼆、问答题" + "\r\n\n");
        for (int idx = 0; idx < answerQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestionList.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestionList.get(idx).getKey()).append("\r\n\n");
        }
        return detail.toString();
    }

}
