package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SpringWorld updateOne(long l) {
        try {

            SpringWorld build = SpringWorld.builder().id(l).age(2).build();
            int update = springWorldDao.updateById(build);

            if(true){
                throw new RuntimeException("13");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

}
