package org.wanbang.redissondelayqueue;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import java.util.concurrent.TimeUnit;

public class OrderTimeoutService {

    private final RedissonClient redissonClient;
    private final RBlockingQueue<String> blockingQueue;
    private final RDelayedQueue<String> delayedQueue;

    public OrderTimeoutService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
        this.blockingQueue = redissonClient.getBlockingQueue("order_timeout_queue");
        // 1. 创建 RDelayedQueue：当你调用 redissonClient.getDelayedQueue(blockingQueue) 时，Redisson 会创建一个 RDelayedQueue 实例，并将其与 blockingQueue 关联起来。
        // 2. 后台任务：Redisson 会启动一个后台任务，定期检查 RDelayedQueue 中的元素。这个任务会不断地扫描 RDelayedQueue，查找那些延迟时间已经到达的元素。
        // 3. 元素移动：当某个元素的延迟时间到达时，Redisson 会将该元素从 RDelayedQueue 中移除，并将其放入与之关联的 blockingQueue 中。
        // 4. 消费者处理：一旦元素被移动到 blockingQueue，消费者可以通过 blockingQueue.take() 或其他类似的方法从队列中取出并处理这些元素。
        // 个人总结：自己看源码 <V> RDelayedQueue<V> getDelayedQueue(RQueue<V> destinationQueue);
        this.delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
    }

    /**
     * 添加订单到延迟队列
     *
     * @param orderId 订单ID
     * @param delay   延迟时间
     * @param unit    时间单位
     */
    public void addOrder(String orderId, long delay, TimeUnit unit) {
        delayedQueue.offer(orderId, delay, unit);
        System.out.println("订单 " + orderId + " 已添加到延迟队列，超时时间：" + delay + " " + unit);
    }

    /**
     * 启动消费者线程，处理超时订单
     */
    public void startConsumer() {
        new Thread(() -> {
            while (true) {
                try {
                    // 从阻塞队列中获取到期的订单
                    String orderId = blockingQueue.take();
                    handleTimeoutOrder(orderId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    /**
     * 处理超时订单
     *
     * @param orderId 订单ID
     */
    private void handleTimeoutOrder(String orderId) {
        System.out.println("订单 " + orderId + " 已超时，正在处理...");
        // 这里实现具体的订单超时逻辑，例如取消订单、退款等
    }

    /**
     * mjj个人添加的
     * @param orderId
     */
    public void dealwithOrder(String orderId) {
        // 移除已经处理的订单
        delayedQueue.remove(orderId);
        System.out.println("订单已被处理");
    }

    /**
     * 关闭延迟队列
     */
    public void shutdown() {
        delayedQueue.destroy();
        redissonClient.shutdown();
    }
}
