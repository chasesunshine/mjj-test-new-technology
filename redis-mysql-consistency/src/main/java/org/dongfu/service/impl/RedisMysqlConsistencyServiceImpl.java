package org.dongfu.service.impl;

import org.dongfu.dao.RedisMysqlConsistencyDao;
import org.dongfu.entity.RedisMysqlConsistency;
import org.dongfu.service.RedisMysqlConsistencyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
@Service
public class RedisMysqlConsistencyServiceImpl implements RedisMysqlConsistencyService {
    @Resource
    private RedisMysqlConsistencyDao redisMysqlConsistencyDao;

    @Override
    public RedisMysqlConsistency queryById(long l) {
        RedisMysqlConsistency redisMysqlConsistency = redisMysqlConsistencyDao.selectById(l);
        return redisMysqlConsistency;
    }
}
