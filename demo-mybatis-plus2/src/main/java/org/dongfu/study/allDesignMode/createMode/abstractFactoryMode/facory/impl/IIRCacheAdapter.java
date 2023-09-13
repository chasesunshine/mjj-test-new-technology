package org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.facory.impl;

import org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.entity.IIR;
import org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.facory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:19
* @version 1.0
*/

public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();
    public String get(String key) {
        return iir.get(key);
    }
    public void set(String key, String value) {
        iir.set(key, value);
    }
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }
    public void del(String key) {
        iir.del(key);
    }
}
