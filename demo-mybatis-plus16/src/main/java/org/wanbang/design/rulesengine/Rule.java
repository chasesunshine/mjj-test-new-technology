package org.wanbang.design.rulesengine;

import java.math.BigDecimal;

/**
 * 规则引擎可以帮助你将逻辑和数据解耦，数据放入领域模型中，逻辑放入规则中
 * 电商领域的规则引擎可以用来处理价格计算、促销活动、优惠券使用等复杂的业务逻辑。以下是一个电商领域的规则引擎的简单示例代码：
 * 假设我们需要计算某个商品的价格，考虑到会有多种不同的优惠策略，如会员折扣、新用户优惠、满减等，这时我们可以使用规则引擎来实现灵活的计价方案。
 * 首先我们定义一个Rule类，用来表示一个规则：
 * 在这里，我们定义了两个抽象方法 `evaluate`和 `calculate`，分别用来评估当前规则是否适用于给定的对象（如某个订单）以及如何计算折扣后的价格等。
 * @param <T>
 */
public abstract class Rule<T> {
    private String ruleName;
    private int priority;

    public abstract boolean evaluate(T obj);

    public abstract BigDecimal calculate(T obj);

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
