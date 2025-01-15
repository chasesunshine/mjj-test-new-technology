# ScheduledExecutorService 定时任务简单使用
    如果您正在编写一个不涉及事件处理的简单调度任务，并且不需要传递任何事件参数，那么您的方法签名应该是没有参数的。然而，如果是在上下文中需要遵循某个框架的事件监听机制，那么您需要确保方法签名符合该框架的要求。
    例如，在Spring中使用@EventListener注解时，方法必须至少接受一个参数，该参数是要监听的事件类型。下面是一个简单的例子：
    import org.springframework.context.event.EventListener;
    import org.springframework.stereotype.Component;

    @Component
    public class SchedulerExample {

        @EventListener
        public void testScheduler(CustomEvent event) {
            // 处理事件逻辑
            System.out.println("Received event: " + event);
        }
    }

    在这个例子中，CustomEvent 是一个自定义事件类，当您发布这种类型的事件时，带有 @EventListener 注解的方法将会被调用来处理它。
    但是，如果您的意图仅仅是创建一个定时任务，而不涉及到事件监听，那么您可以忽略此错误消息，因为它可能并不适用于您的场景。您可以使用 ScheduledExecutorService 来安排定期执行的任务，而无需关心事件监听器的规则。比如：

    import java.util.concurrent.Executors;
    import java.util.concurrent.ScheduledExecutorService;
    import java.util.concurrent.TimeUnit;
    
    public class SchedulerExample {
    
        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
        public void start() {
            Runnable task = () -> {
                // 定时任务的逻辑
                System.out.println("Task is running at " + System.currentTimeMillis());
            };
    
            // 安排一个无参的定时任务
            scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
        }
    
        public void shutdown() {
            scheduler.shutdown();
        }
    
        public static void main(String[] args) {
            SchedulerExample example = new SchedulerExample();
            example.start();
    
            // 让程序运行一段时间后关闭调度器
            try {
                Thread.sleep(10000); // 等待10秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                example.shutdown();
            }
        }
    }
    
    这段代码展示了如何使用 ScheduledExecutorService 来安排一个无参的定时任务。请注意，这里并没有涉及任何事件监听的概念，因此也不需要事件参数。如果您确实需要实现一个事件监听器，请提供更多的背景信息以便我能给出更准确的帮助。
