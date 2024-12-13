# CyclicBarrier  使用demo (详见 demo-mybatis-plus16/src/main/java/org/wanbang/util/Test.java)
    当然，下面是一个使用 CyclicBarrier 的简单示例。这个例子展示了如何创建一个 CyclicBarrier 并用它来协调多个线程的工作。我们将模拟三个工人完成他们的任务，并在所有工人到达屏障点后一起继续。
    示例：工人协作
    在这个场景中，我们有三个工人（线程），每个工人将执行一些工作，然后等待其他工人也完成他们自己的工作。当所有人都完成了工作并到达了屏障点时，他们会一起继续下一个阶段的工作。

    import java.util.concurrent.BrokenBarrierException;
    import java.util.concurrent.CyclicBarrier;

    public class CyclicBarrierDemo {

        public static void main(String[] args) {
            // 创建一个需要3个线程到达才能继续的CyclicBarrier，并定义所有线程到达后要执行的动作
            final CyclicBarrier barrier = new CyclicBarrier(3, () -> {
                System.out.println("All workers have completed their tasks and are ready to proceed.");
            });

            // 启动三个工人线程
            for (int i = 1; i <= 3; i++) {
                new Thread(new Worker(barrier, "Worker-" + i)).start();
            }
        }

        // 定义工人线程类
        static class Worker implements Runnable {
            private final CyclicBarrier barrier;
            private final String name;

            Worker(CyclicBarrier barrier, String name) {
                this.barrier = barrier;
                this.name = name;
            }

            @Override
            public void run() {
                try {
                    System.out.println(name + " is working...");

                    // 模拟工作过程，随机延迟以显示不同步性
                    Thread.sleep((long)(Math.random() * 2000));

                    System.out.println(name + " has finished its work and is waiting at the barrier.");

                    // 等待其他工人到达屏障
                    barrier.await();

                    System.out.println(name + " has been released from the barrier and can continue.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.err.println(name + " was interrupted or barrier was broken.");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    解释
    CyclicBarrier 初始化：我们创建了一个 CyclicBarrier 实例，指定了需要 3 个线程到达屏障点。同时，我们还提供了一个 Runnable，它将在所有线程到达屏障后执行。
    工人线程：我们为每个工人创建了一个线程，它们都实现了 Runnable 接口。每个工人先进行自己的工作，然后调用 barrier.await() 方法等待其他工人。
    屏障动作：当所有工人到达屏障时，会执行我们在构造 CyclicBarrier 时提供的 Runnable，打印出一条消息表示所有工人已经准备好继续。
    异常处理：如果某个工人被中断或者屏障被破坏（例如由于超时或另一个工人抛出了异常），那么相应的异常会被捕获并处理。
    运行结果
    当你运行这段代码时，你会看到类似以下的输出（注意，由于线程执行的顺序是不确定的，实际输出可能会有所不同）：

    Worker-1 is working...
    Worker-2 is working...
    Worker-3 is working...
    Worker-2 has finished its work and is waiting at the barrier.
    Worker-1 has finished its work and is waiting at the barrier.
    Worker-3 has finished its work and is waiting at the barrier.
    All workers have completed their tasks and are ready to proceed.
    Worker-2 has been released from the barrier and can continue.
    Worker-1 has been released from the barrier and can continue.
    Worker-3 has been released from the barrier and can continue.
    通过这个简单的例子，你可以看到 CyclicBarrier 如何帮助你同步多个线程的行为，确保它们在特定点上同步并一起继续执行。如果你还有更具体的问题或需要进一步的帮助，请随时告诉我！

# CountDownLaunch (详见 demo-mybatis-plus2/src/main/java/org/wanbang/study/CountDownLaunchTest/Test2/InitializationExample.java)
    CountDownLatch的应用场景：
    > CountDownLatch最多的使用场景就是在等待多个线程操作都完成后，再让后续业务继续执行的业务中……
    >
    > 这么解释没毛病：但是推荐大家，在面试的过程中，这个点最好结合自己的项目去聊……你在哪家公司的哪个项目中的什么功能里，就涉及了………………

    CyclicBarrier的应用场景：
    > * 比如类似游戏中，玩王者荣耀，LOL等等，需要等待10个客户端都匹配到位，才能开始游戏，这个10个客户端才会开始加载游戏……
    > * 比如一个旅游的APP，需要报团，这个团可能有时间限制，同时还有人数的限制，如果撇去时间，等到人数到达了阈值，才会触发后续的一些。
    > * 电商拼团，PDD，至少2人成团…………

    **哪个可以复用，为什么？**

    其实这哥俩都有一个特点，都需要等待多个线程做了什么事情，才能往下继续。

    * CountDownLatch是基于AQS中的state做计数，每完成一个任务，countDown方法执行后，会对state - 1，当state为0后，就会唤醒那些基于CountDownLatch执行await的线程。
    * CyclicBarrier是自己搞了一个count属性，每当有一个线程到位 **（执行CyclicBarrier的await方法）** 之后，就会对count进行--操作。等到count计数到0后，依然会唤醒，可以优先触发一个任务，然后唤醒所有到位的线程。

    CyclicBarrier是可以复用的。 他提供了一个reset的方法，在这个reset方法中，会将所有之前到位，和即将到位的线程全部唤醒结束，同时重置count计数器，清空当前CyclicBarrier，以便下次使用