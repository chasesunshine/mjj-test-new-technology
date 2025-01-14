package org.wanbang.design.rulesengine.rule;

import org.wanbang.design.rulesengine.Rule;

import java.math.BigDecimal;

public class NewUserDiscountRule extends Rule<Order> {
    // ...

    @Override
    public boolean evaluate(Order obj) {
        return obj.getUser().isNewUser();
    }

    @Override
    public BigDecimal calculate(Order obj) {
        return obj.getTotalPrice().subtract(new BigDecimal("5")); // 新用户减5元
    }
}
