package org.wanbang.study.ioc.ioc10.entity;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/24 16:06
* @version 1.0
*/

/**
 *  这两个类的作用就是创建出一个用于传递类中属性信息的类，因为属性可能会有很
 * 多，所以还需要定义一个集合包装下。
 */
public class PropertyValue {
    private final String name;
    private final Object value;
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
