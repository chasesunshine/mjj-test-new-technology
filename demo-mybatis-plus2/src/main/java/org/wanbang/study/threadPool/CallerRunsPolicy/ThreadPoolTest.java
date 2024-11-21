package org.wanbang.study.threadPool.CallerRunsPolicy;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CallerRunsPolicy 拒绝策略有什么风险？如何解决？我们上面也提到了：如果想要保证任何一个任务请求都要被执行的话，
 * 那选择 CallerRunsPolicy 拒绝策略更合适一些。不过，如果走到CallerRunsPolicy的任务是个非常耗时的任务，
 * 且处理提交任务的线程是主线程，可能会导致主线程阻塞，影响程序的正常运行。
 * 这里简单举一个例子，该线程池限定了最大线程数为 2，阻塞队列大小为 1(这意味着第 4 个任务就会走到拒绝策略)，ThreadUtil为 Hutool 提供的工具类：
 *
 */
public class ThreadPoolTest {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolTest.class);

    public static void main(String[] args) {
        // 创建一个线程池，核心线程数为1，最大线程数为2
        // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间为60秒，
        // 任务队列为容量为1的ArrayBlockingQueue，饱和策略为CallerRunsPolicy。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // 提交第一个任务，由核心线程执行
        threadPoolExecutor.execute(() -> {
            log.info("核心线程执行第一个任务");
            ThreadUtil.sleep(1, TimeUnit.MINUTES);
        });

        // 提交第二个任务，由于核心线程被占用，任务将进入队列等待
        threadPoolExecutor.execute(() -> {
            log.info("非核心线程处理入队的第二个任务");
            ThreadUtil.sleep(1, TimeUnit.MINUTES);
        });

        // 提交第三个任务，由于核心线程被占用且队列已满，创建非核心线程处理
        threadPoolExecutor.execute(() -> {
            log.info("非核心线程处理第三个任务");
            ThreadUtil.sleep(1, TimeUnit.MINUTES);
        });

        // 提交第四个任务，由于核心线程和非核心线程都被占用，队列也满了，根据CallerRunsPolicy策略，任务将由提交任务的线程（即主线程）来执行
        threadPoolExecutor.execute(() -> {
            log.info("主线程处理第四个任务");
            ThreadUtil.sleep(2, TimeUnit.MINUTES);
        });

        // 提交第五个任务，主线程被第四个任务卡住，该任务必须等到主线程执行完才能提交
        threadPoolExecutor.execute(() -> {
            log.info("核心线程执行第五个任务");
        });

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }

    /**
     * 从输出结果可以看出，因为CallerRunsPolicy这个拒绝策略，导致耗时的任务用了主线程执行，
     * 导致线程池阻塞，进而导致后续任务无法及时执行，严重的情况下很可能导致 OOM。
     * 我们从问题的本质入手，调用者采用CallerRunsPolicy是希望所有的任务都能够被执行，
     * 暂时无法处理的任务又被保存在阻塞队列BlockingQueue中。这样的话，在内存允许的情况下，
     * 我们可以增加阻塞队列BlockingQueue的大小并调整堆内存以容纳更多的任务，确保任务能够被准确执行。
     * 为了充分利用 CPU，我们还可以调整线程池的maximumPoolSize （最大线程数）参数，
     * 这样可以提高任务处理速度，避免累计在 BlockingQueue的任务过多导致内存用完。
     */
}
