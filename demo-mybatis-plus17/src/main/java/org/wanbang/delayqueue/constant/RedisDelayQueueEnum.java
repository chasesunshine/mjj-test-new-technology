package org.wanbang.delayqueue.constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 描述: 延迟队列业务枚举
 * 时间: 2022/8/05 14:16
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RedisDelayQueueEnum {
    orderPaymentTimeout("home_analysis:countdown","订单支付超时，自动取消订单", "orderPaymentTimeout"),
    orderNotEvaluatedTimeout("orderNotEvaluatedTimeout", "订单超时未评价，系统默认好评", "orderNotEvaluatedTimeout");
    /**
     * 延迟队列 Redis Key
     */
    private String code;
    /**
     * 中文描述
     */
    private String name;
    /**
     * 延迟队列具体业务实现的 Bean
     * 可通过 Spring 的上下文获取
     */
    private String beanId;
}
