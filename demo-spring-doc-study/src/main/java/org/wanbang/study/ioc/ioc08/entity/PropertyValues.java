package org.wanbang.study.ioc.ioc08.entity;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/24 16:06
* @version 1.0
*/

/**
 *  这两个类的作用就是创建出一个用于传递类中属性信息的类，因为属性可能会有很
 * 多，所以还需要定义一个集合包装下。
 *
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
