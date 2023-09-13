package org.dongfu.study.springEvent.difficult.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.dongfu.study.springEvent.difficult.eventImpl.SimpleEventMulticaster;
import org.dongfu.study.springEvent.difficult.listener.EventListener;
import org.dongfu.study.springEvent.difficult.listenerManage.EventMulticaster;
import org.dongfu.study.springEvent.difficult.service.UserRegisterService;

import java.util.List;

/**
* @description: 事件发布者
* @author majiajian
* @date 2022/12/7 14:33
* @version 1.0
*/

@Configuration
@ComponentScan
public class MainConfig0 {

    /**
     * 注册一个bean：事件发布者
     *
     * @param eventListeners
     * @return
     */
    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListeners) { //@1
        EventMulticaster eventPublisher = new SimpleEventMulticaster();
        if (eventListeners != null) {
            eventListeners.forEach(eventPublisher::addEventListener);
        }
        return eventPublisher;
    }

    /**
     * 注册一个bean：用户注册服务
     *
     * @param eventMulticaster
     * @return
     */
    @Bean
    public UserRegisterService userRegisterService(EventMulticaster eventMulticaster) { //@2
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.setEventMulticaster(eventMulticaster);
        return userRegisterService;
    }
}
