package org.dongfu.service.impl;

import org.dongfu.dao.CanalMysqlListenerDao;
import org.dongfu.entity.CanalMysqlListener;
import org.dongfu.service.CanalMysqlListenerService;
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
public class CanalMysqlListenerServiceImpl implements CanalMysqlListenerService {
    @Resource
    private CanalMysqlListenerDao canalMysqlListenerDao;

    @Override
    public CanalMysqlListener queryById(int l) {
        CanalMysqlListener canalMysqlListener = canalMysqlListenerDao.selectById(l);
        return canalMysqlListener;
    }

    @Override
    public Integer insertData() {
        CanalMysqlListener build = CanalMysqlListener.builder().age(2).email("123").name("测试").build();
        int insert = canalMysqlListenerDao.insert(build);
        return insert;
    }
}
