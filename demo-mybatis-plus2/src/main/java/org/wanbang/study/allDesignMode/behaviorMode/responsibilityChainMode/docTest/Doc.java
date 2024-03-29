package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest;
/**
* @description: 责任链模式
* @author majiajian
* @date 2022/8/18 16:29
* @version 1.0
*/

/**
 *
 * 击⿎传雷，看上图你是否想起周星驰有⼀个电影，⼤家坐在海边围成⼀个圈，拿着⼀个点燃的炸弹，互
 * 相传递。
 * 责任链模式的核⼼是解决⼀组服务中的先后执⾏处理关系，就有点像你没钱花了，需要家庭财务⽀出审
 * 批，10块钱以下找闺⼥审批，100块钱先闺⼥审批在媳妇审批。你可以理解想象成当你要跳槽的时候被
 * 安排的明明⽩⽩的被各个领导签字放⾏。
 *
 */
public class Doc {

    /**
     *
     * 责任链模式可以让各个服务模块更加清晰，⽽每⼀个模块间可以通过 next 的⽅式进⾏获取。⽽每⼀
     * 个 next 是由继承的统⼀抽象类实现的。最终所有类的职责可以动态的进⾏编排使⽤，编排的过程可以
     * 做成可配置化
     *
     */
}
