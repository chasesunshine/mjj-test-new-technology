package org.wanbang.design.rulesengine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 在这里，我们定义了一个 `addRule`方法和一个 `execute`方法。其中 `addRule`用来添加规则，而 `execute`方法则用来执行规则引擎的逻辑。
 * 在 `execute`方法中，我们首先对规则按照优先级进行排序，然后依次运行每一个规则。如果当前规则适用于给定的对象，则执行该规则的计算方法，累加价格并返回。
 *
 * @param <T>
 */
public class RuleEngine<T> {
    private List<Rule<T>> rules;

    public RuleEngine() {
        rules = new ArrayList<>();
    }

    public void addRule(Rule<T> rule) {
        rules.add(rule);
    }

    public BigDecimal execute(T obj) {
        rules.sort(Comparator.comparingInt(Rule::getPriority));
        BigDecimal price = BigDecimal.ZERO;
        for (Rule<T> rule : rules) {
            if (rule.evaluate(obj)) {
                price = rule.calculate(obj);
            }
        }
        return price;
    }
}
