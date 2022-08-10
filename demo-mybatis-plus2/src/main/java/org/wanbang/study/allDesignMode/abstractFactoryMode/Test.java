package org.wanbang.study.allDesignMode.abstractFactoryMode;

import org.wanbang.study.allDesignMode.abstractFactoryMode.service.CacheService;
import org.wanbang.study.allDesignMode.abstractFactoryMode.facory.JDKProxy;
import org.wanbang.study.allDesignMode.abstractFactoryMode.facory.impl.EGMCacheAdapter;
import org.wanbang.study.allDesignMode.abstractFactoryMode.facory.impl.IIRCacheAdapter;
import org.wanbang.study.allDesignMode.abstractFactoryMode.service.impl.CacheServiceImpl;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/10 20:39
* @version 1.0
*/

public class Test {
    public static void main(String[] args) throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","⼩傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","⼩傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }
}
