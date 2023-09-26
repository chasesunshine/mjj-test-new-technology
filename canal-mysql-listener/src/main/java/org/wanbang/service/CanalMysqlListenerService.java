package org.wanbang.service;

import org.wanbang.entity.CanalMysqlListener;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
public interface CanalMysqlListenerService {

    Integer insertData();

    CanalMysqlListener queryById(int i);
}
