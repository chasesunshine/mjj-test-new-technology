package org.dongfu.util.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * IOC上下文工具类
 *
 * @author Xiongmw
 */
@Slf4j
@Component
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    private static long svcNodeId = -1L;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        try {
            if (Objects.isNull(applicationContext)) {
                synchronized (SpringContextHolder.class) {
                    if (Objects.isNull(applicationContext)) {
                        log.debug("wait SpringContextHolder init!");
                        SpringContextHolder.class.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("wait SpringContextHolder init error!", e);
        }
        return applicationContext;
    }

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
        synchronized (SpringContextHolder.class) {
            SpringContextHolder.class.notifyAll();
            log.info("init SpringContextHolder success!");
        }
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public <T> T getBean(String name) {
        return Optional.ofNullable(getApplicationContext())
                .map(app -> (T) app.getBean(name))
                .orElse(null);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public <T> T getBean(Class<T> requiredType) {
        return Optional.ofNullable(getApplicationContext())
                .map(app -> app.getBean(requiredType))
                .orElse(null);
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() {
        SpringContextHolder.clearHolder();
    }

}
