在 Java 中，线程之间传递数据可以通过多种方式实现。以下是几种常见的方法：

---

### 1. **共享变量（使用 `volatile` 或 `synchronized`）**
通过共享变量在线程之间传递数据，需要注意线程安全问题。

#### 示例：
```java
class SharedData {
    private volatile int data; // 使用 volatile 确保可见性

    public synchronized void setData(int data) {
        this.data = data;
    }

    public synchronized int getData() {
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.setData(i);
                System.out.println("Producer set data: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int data = sharedData.getData();
                System.out.println("Consumer get data: " + data);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**注意：**
- `volatile` 关键字确保变量的可见性，但不保证原子性。
- 如果需要更复杂的同步逻辑，可以使用 `synchronized` 或 `ReentrantLock`。

---

### 2. **使用 `BlockingQueue`**
`BlockingQueue` 是一种线程安全的队列，常用于生产者-消费者模式。

#### 示例：
```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    queue.put(i); // 阻塞式添加数据
                    System.out.println("Producer put: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    int data = queue.take(); // 阻塞式获取数据
                    System.out.println("Consumer take: " + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**优点：**
- `BlockingQueue` 提供了线程安全的操作，无需手动管理同步。
- 支持阻塞操作，适合生产者-消费者场景。

---

### 3. **使用 `Exchanger`**
`Exchanger` 是一个用于两个线程之间交换数据的工具类。

#### 示例：
```java
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread threadA = new Thread(() -> {
            try {
                String data = "Hello from A";
                System.out.println("Thread A sending: " + data);
                String received = exchanger.exchange(data); // 交换数据
                System.out.println("Thread A received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                String data = "Hello from B";
                System.out.println("Thread B sending: " + data);
                String received = exchanger.exchange(data); // 交换数据
                System.out.println("Thread B received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
```

**优点：**
- 适用于两个线程之间的双向数据交换。
- 使用简单，自动处理同步问题。

---

### 4. **使用 `FutureTask`**
`FutureTask` 可以用来在线程之间传递计算结果。

#### 示例：
```java
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Calculating result...");
                Thread.sleep(2000);
                return 42; // 返回计算结果
            }
        });

        Thread worker = new Thread(futureTask);
        worker.start();

        System.out.println("Waiting for result...");
        int result = futureTask.get(); // 获取结果
        System.out.println("Result: " + result);
    }
}
```

**优点：**
- 适用于异步任务的结果传递。
- 结合线程池使用时更加高效。

---

### 5. **使用 `wait()` 和 `notify()`**
通过对象的内置锁机制实现线程间通信。

#### 示例：
```java
class DataBox {
    private int data;
    private boolean isEmpty = true;

    public synchronized void produce(int value) throws InterruptedException {
        while (!isEmpty) {
            wait(); // 等待消费者消费数据
        }
        this.data = value;
        isEmpty = false;
        System.out.println("Produced: " + value);
        notifyAll(); // 通知消费者
    }

    public synchronized int consume() throws InterruptedException {
        while (isEmpty) {
            wait(); // 等待生产者生产数据
        }
        isEmpty = true;
        System.out.println("Consumed: " + data);
        notifyAll(); // 通知生产者
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    dataBox.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    dataBox.consume();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

**优点：**
- 适用于复杂的线程间协作场景。
- 提供细粒度的控制。

---

### 总结
- 如果是简单的数据共享，可以使用 **共享变量**。
- 如果是生产者-消费者模式，推荐使用 **`BlockingQueue`**。
- 如果需要两个线程之间交换数据，可以使用 **`Exchanger`**。
- 如果需要异步任务的结果，可以使用 **`FutureTask`**。
- 如果需要复杂的线程间协作，可以使用 **`wait()` 和 `notify()`**。

根据具体需求选择合适的方案！