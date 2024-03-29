package org.wanbang.service.impl;

import org.wanbang.dao.RedisMysqlConsistencyDao;
import org.wanbang.entity.RedisMysqlConsistency;
import org.wanbang.service.RedisMysqlConsistencyService;
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

    @Override
    public Integer insertData() {
        RedisMysqlConsistency build = RedisMysqlConsistency.builder().age(2).email("123").name("测试").build();
        int insert = redisMysqlConsistencyDao.insert(build);
        return insert;
    }
}
