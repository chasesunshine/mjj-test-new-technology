package org.wanbang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.UUID;

/**
 * a）MDC 提供的 put 方法，可以将一个 K-V 的键值对放到容器中，并且能保证同一个线程内，Key 是唯一的，
 *    不同的线程 MDC 的值互不影响；
 * b)  在 logback.xml 中，在 layout 中可以通过声明 %X{REQ_ID} 来输出 MDC 中 REQ_ID 的信息；
 * c）MDC 提供的 remove 方法，可以清除 MDC 中指定 key 对应的键值对信息。
 *
 * 通过快速入门的程序，得知 MDC 的值与线程是绑定在一起的，不同线程互不影响，MDC 背后到底是怎么实现的呢？不妨从源码上看一看。
 *
 */


/**
 * MDC快速入门示例
 *
 * @author 一猿小讲
 */
public class SimpleMDC {
    public static void main(String[] args) {
        new BizHandle("F0000").start();
        new BizHandle("F9999").start();
    }
}


class BizHandle extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
    public static final String REQ_ID = "REQ_ID";


    private String funCode;


    public BizHandle(String funCode) {
        this.funCode = funCode;
    }


    @Override
    public void run() {
        MDC.put(REQ_ID, UUID.randomUUID().toString());
        logger.info("开始调用服务{}，进行业务处理", funCode);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
        logger.info("服务{}处理完毕，可以释放空间了，避免内存泄露", funCode);
        MDC.remove(REQ_ID);
    }
}
