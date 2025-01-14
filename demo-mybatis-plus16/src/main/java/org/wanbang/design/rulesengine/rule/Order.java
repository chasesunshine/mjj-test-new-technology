package org.wanbang.design.rulesengine.rule;

import lombok.Data;
import org.wanbang.design.rulesengine.User;

import java.math.BigDecimal;

@Data
public class Order {

    private BigDecimal totalPrice;

    private User user;
}
