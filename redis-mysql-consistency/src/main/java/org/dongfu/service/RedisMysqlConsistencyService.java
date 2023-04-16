package org.dongfu.service;

import org.dongfu.entity.RedisMysqlConsistency;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
public interface RedisMysqlConsistencyService {

    RedisMysqlConsistency queryById(long l);
}
