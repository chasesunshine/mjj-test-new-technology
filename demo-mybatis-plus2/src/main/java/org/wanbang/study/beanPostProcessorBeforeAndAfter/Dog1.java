package org.wanbang.study.beanPostProcessorBeforeAndAfter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Slf4j
@Component
public class Dog1 implements InitializingBean {
    private String name = "旺财";
    private String color = "黑色";
    public Dog1() {
        log.info("---dog的无参构造方法被执行");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("---afterPropertiesSet被执行");
    }
    public void init() {
        log.info("---initMethod被执行");
    }
}
