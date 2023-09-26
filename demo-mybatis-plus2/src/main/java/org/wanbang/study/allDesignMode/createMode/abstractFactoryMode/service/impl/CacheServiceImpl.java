package org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.service.impl;

import org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.service.CacheService;
import org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.entity.EGM;
import org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.entity.IIR;
import org.wanbang.study.allDesignMode.createMode.abstractFactoryMode.util.RedisUtils;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/10 20:35
 * @version 1.0
 */

public class CacheServiceImpl implements CacheService {
    private RedisUtils redisUtils = new RedisUtils();
    private EGM egm = new EGM();
    private IIR iir = new IIR();

    @Override
    public String get(String key, int redisType) {
        if (1 == redisType) {
            return egm.gain(key);
        }
        if (2 == redisType) {
            return iir.get(key);
        }
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            egm.set(key, value);
            return;
        }
        if (2 == redisType) {
            iir.set(key, value);
            return;
        }
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    //... 同类不做太多展示，可以下载源码进⾏参考
}