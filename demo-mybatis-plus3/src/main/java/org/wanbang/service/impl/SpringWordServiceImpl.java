package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.wanbang.entity.SpringWorld;
import org.wanbang.dao.SpringWorldDao;
import org.wanbang.service.SpringWordService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class SpringWordServiceImpl implements SpringWordService {
    @Resource
    private SpringWorldDao springWorldDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SpringWorld queryById(Long id) {
        log.info("通过ID查询单条数据");

        return this.springWorldDao.queryById(id);
    }

}
