package com.dongfu.service.impl;

import com.dongfu.dao.CanalMysqlListenerDao;
import com.dongfu.service.CanalMysqlListenerService;
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

}
