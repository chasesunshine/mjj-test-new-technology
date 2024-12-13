package org.wanbang.design.rulesengine;

import org.wanbang.design.rulesengine.rule.MemberDiscountRule;
import org.wanbang.design.rulesengine.rule.NewUserDiscountRule;
import org.wanbang.design.rulesengine.rule.Order;
import org.wanbang.design.rulesengine.rule.Over100DiscountRule;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        RuleEngine<Order> engine = new RuleEngine<>();
        engine.addRule(new MemberDiscountRule());
        engine.addRule(new NewUserDiscountRule());
        engine.addRule(new Over100DiscountRule());

        Order order = new Order();
        // 初始化订单信息，如商品列表、会员信息等

        BigDecimal finalPrice = engine.execute(order);
    }
}
