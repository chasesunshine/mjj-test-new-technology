package org.wanbang.study.springEvent.difficult.eventImpl;
/**
* @description: 事件广播默认实现
* @author majiajian
* @date 2022/12/7 13:52
* @version 1.0
*/

import org.wanbang.study.springEvent.difficult.event.AbstractEvent;
import org.wanbang.study.springEvent.difficult.listener.EventListener;
import org.wanbang.study.springEvent.difficult.listenerManage.EventMulticaster;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件广播器简单实现
 */
public class SimpleEventMulticaster implements EventMulticaster {

    private Map<Class<?>, List<EventListener>> eventObjectEventListenerMap = new ConcurrentHashMap<>();

    @Override
    public void multicastEvent(AbstractEvent event) {
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(event.getClass());
        if (eventListeners != null) {
            for (EventListener eventListener : eventListeners) {
                eventListener.onEvent(event);
            }
        }
    }

    @Override
    public void addEventListener(EventListener<?> listener) {
        Class<?> eventType = this.getEventType(listener);
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(eventType);
        if (eventListeners == null) {
            eventListeners = new ArrayList<>();
            this.eventObjectEventListenerMap.put(eventType, eventListeners);
        }
        eventListeners.add(listener);
    }

    @Override
    public void removeEventListener(EventListener<?> listener) {
        Class<?> eventType = this.getEventType(listener);
        List<EventListener> eventListeners = this.eventObjectEventListenerMap.get(eventType);
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    /**
     * 获取事件监听器需要监听的事件类型
     *
     * @param listener
     * @return
     */
    protected Class<?> getEventType(EventListener listener) {
        ParameterizedType parameterizedType = (ParameterizedType) listener.getClass().getGenericInterfaces()[0];
        Type eventType = parameterizedType.getActualTypeArguments()[0];
        return (Class<?>) eventType;
    }

}
