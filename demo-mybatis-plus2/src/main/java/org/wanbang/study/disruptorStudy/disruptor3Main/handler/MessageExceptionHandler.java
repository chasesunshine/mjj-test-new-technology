package org.wanbang.study.disruptorStudy.disruptor3Main.handler;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 13:33
* @version 1.0
*/

import com.lmax.disruptor.ExceptionHandler;
import org.wanbang.study.disruptorStudy.disruptor3Main.event.MessageEvent;

/**
 * 异常处理类
 */
public class MessageExceptionHandler implements ExceptionHandler<MessageEvent> {

    @Override
    public void handleEventException(Throwable ex, long sequence, MessageEvent event) {
        ex.printStackTrace();
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        ex.printStackTrace();

    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        ex.printStackTrace();
    }

}
