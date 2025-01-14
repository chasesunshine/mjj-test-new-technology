package org.wanbang.design.rulesengine.rule;

import org.wanbang.design.rulesengine.Rule;

import java.math.BigDecimal;

public class Over100DiscountRule extends Rule<Order> {
    // ...

    @Override
    public boolean evaluate(Order obj) {
        return obj.getTotalPrice().compareTo(new BigDecimal("100")) >= 0;
    }

    @Override
    public BigDecimal calculate(Order obj) {
        return obj.getTotalPrice().subtract(new BigDecimal("10")); // 满100减10元
    }
}
