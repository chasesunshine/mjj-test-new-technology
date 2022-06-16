package org.wanbang.service.impl;

import org.wanbang.entity.SpringWord;
import org.wanbang.dao.SpringWordDao;
import org.wanbang.service.SpringWordService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Service
public class SpringWordServiceImpl implements SpringWordService {
    @Resource
    private SpringWordDao springWordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SpringWord queryById(Long id) {
        return this.springWordDao.queryById(id);
    }

}
