package org.wanbang.study.allDesignMode.constructMode.proxyMode.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.wanbang.study.allDesignMode.constructMode.proxyMode.anno.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/18 16:07
 * @version 1.0
 */

public class MapperFactoryBean<T> implements FactoryBean<T> {
    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);
    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            logger.info("SQL：{}", select.value().replace("#{uId}", args[0].toString()));
            return args[0] + ",⼩傅哥,bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！";
        };
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
