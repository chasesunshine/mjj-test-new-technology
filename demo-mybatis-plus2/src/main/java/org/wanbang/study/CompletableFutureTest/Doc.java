package org.wanbang.study.CompletableFutureTest;

/**
 * https://javaguide.cn/java/concurrent/completablefuture-intro.html
 *
 * 实际项目中，一个接口可能需要同时获取多种不同的数据，然后再汇总返回，这种场景还是挺常见的。
 * 举个例子：用户请求获取订单信息，可能需要同时获取用户信息、商品详情、物流信息、商品推荐等数据。
 * 如果是串行（按顺序依次执行每个任务）执行的话，接口的响应速度会非常慢。
 * 考虑到这些任务之间有大部分都是 无前后顺序关联 的，可以 并行执行 ，
 * 就比如说调用获取商品详情的时候，可以同时调用获取物流信息。通过并行执行多个任务的方式，接口的响应速度会得到大幅优化。
 *
 * 对于存在前后调用顺序关系的任务，可以进行任务编排。
 *   1. 获取用户信息之后，才能调用商品详情和物流信息接口。
 *   2. 成功获取商品详情和物流信息之后，才能调用商品推荐接口。
 * 可能会用到多线程异步任务编排的场景（这里只是举例，数据不一定是一次返回，可能会对接口进行拆分）：
 *      1. 首页：例如技术社区的首页可能需要同时获取文章推荐列表、广告栏、文章排行榜、热门话题等信息。
 *      2. 详情页：例如技术社区的文章详情页可能需要同时获取作者信息、文章详情、文章评论等信息。
 *      3. 统计模块：例如技术社区的后台统计模块可能需要同时获取粉丝数汇总、文章数据（阅读量、评论量、收藏量）汇总等信息。
 * 对于 Java 程序来说，Java 8 才被引入的 CompletableFuture 可以帮助我们来做多个任务的编排，功能非常强大。
 *
 * 原文链接：https://javaguide.cn/java/concurrent/completablefuture-intro.html
 *
 */

/**
 * CompletableFuture 是 Java 8 引入的一个强大的异步编程工具，
 * 它实现了 Future 和 CompletionStage 接口，提供了丰富的异步编程方法。
 * 下面是一个详细的 CompletableFuture 使用示例，涵盖了常见的异步操作和组合操作。
 *
 * 总结
 * CompletableFuture 提供了丰富的异步编程方法，包括：
 *      supplyAsync：创建一个异步任务，返回一个 CompletableFuture。
 *      thenApplyAsync：在前一个任务完成后，异步地应用一个函数。
 *      thenCombine：组合两个 CompletableFuture 的结果。
 *      handle：处理任务的结果或异常。
 * 通过这些方法，可以轻松地构建复杂的异步任务流，并处理各种异常情况。希望这些示例能帮助你更好地理解和使用 CompletableFuture。
 */
public class Doc {
}
