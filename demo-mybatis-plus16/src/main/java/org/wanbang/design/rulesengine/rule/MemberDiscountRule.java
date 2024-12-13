package org.wanbang.design.rulesengine.rule;

import org.wanbang.design.rulesengine.Rule;

import java.math.BigDecimal;

public class MemberDiscountRule extends Rule<Order> {
    // ...

    @Override
    public boolean evaluate(Order obj) {
        return obj.getUser().isMember();
    }

    @Override
    public BigDecimal calculate(Order obj) {
        return obj.getTotalPrice().multiply(new BigDecimal("0.9")); // 9折优惠
    }
}