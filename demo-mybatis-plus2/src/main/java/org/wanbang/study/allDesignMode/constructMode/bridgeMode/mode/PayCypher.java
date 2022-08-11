package org.wanbang.study.allDesignMode.constructMode.bridgeMode.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.constructMode.bridgeMode.common.IPayMode;

/**
* @description: 密码
* @author majiajian
* @date 2022/8/11 17:05
* @version 1.0
*/

public class PayCypher implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("密码⽀付，⻛控校验环境安全");
        return true;
    }
}
