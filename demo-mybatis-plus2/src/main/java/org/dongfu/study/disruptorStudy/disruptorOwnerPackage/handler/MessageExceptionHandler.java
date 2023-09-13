package org.dongfu.study.disruptorStudy.disruptorOwnerPackage.handler;
/**
* @description: 异常处理类
* @author majiajian
* @date 2022/8/29 13:33
* @version 1.0
*/

import com.lmax.disruptor.ExceptionHandler;
import org.dongfu.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;

/**
 * 异常处理类
 */
public class MessageExceptionHandler implements ExceptionHandler<MessageEventOwner> {

    @Override
    public void handleEventException(Throwable ex, long sequence, MessageEventOwner event) {
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
