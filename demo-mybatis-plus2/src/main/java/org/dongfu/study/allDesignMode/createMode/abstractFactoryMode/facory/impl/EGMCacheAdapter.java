package org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.facory.impl;

import org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.entity.EGM;
import org.dongfu.study.allDesignMode.createMode.abstractFactoryMode.facory.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:12
* @version 1.0
*/

public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
