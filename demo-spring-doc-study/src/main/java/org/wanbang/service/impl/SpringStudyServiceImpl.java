package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.wanbang.entity.SpringStudy;
import org.wanbang.dao.SpringStudyDao;
import org.wanbang.service.SpringStudyService;
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
public class SpringStudyServiceImpl implements SpringStudyService {
    @Resource
    private SpringStudyDao springStudyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SpringStudy queryById(Long id) {
        log.info("通过ID查询单条数据");

        return this.springStudyDao.selectById(id);
    }

}
