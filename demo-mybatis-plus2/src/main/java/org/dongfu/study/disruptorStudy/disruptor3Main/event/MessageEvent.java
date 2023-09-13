package org.dongfu.study.disruptorStudy.disruptor3Main.event;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 13:44
* @version 1.0
*/

/**
 * 消息事件类
 */
public class MessageEvent{
    /**
     * 原始消息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
