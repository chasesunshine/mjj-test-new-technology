package org.dongfu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.dongfu.common.convert.UserConvert;
import org.dongfu.common.dto.UserResp;
import org.dongfu.entity.SpringWorld;
import org.dongfu.dao.SpringWorldDao;
import org.dongfu.entity.User;
import org.dongfu.service.SpringWordService;
import org.springframework.stereotype.Service;
import org.dongfu.util.proxy.CurrentProxy;

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
    @Resource
    private UserConvert userConvert;

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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserResp queryById1(Long id) {
        log.info("通过ID查询单条数据");

        SpringWorld springWorld = this.springWorldDao.queryById(id);
        springWorld.setUser(new User().setName("mjj"));

        UserResp userResp = userConvert.convertToResp(springWorld);
        return userResp;
    }


    @Override
    public SpringWorld updateOne(long l) {
        try {

            SpringWorld build = SpringWorld.builder().id(l).age(21).name("123").build();
            this.updateBatch1(build);

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateBatch1(SpringWorld build){
        int update = springWorldDao.updateById(build);
        if(true){
            throw new RuntimeException("13");
        }
        return update;
    }



    @Override
    public SpringWorld updateTwo(long l) {
        try {

            SpringWorld build = SpringWorld.builder().id(l).age(21).name("123").build();
            SpringWordServiceImpl springWordService = CurrentProxy.currentProxyByAop(SpringWordServiceImpl.class);
            springWordService.updateBatch2(build);

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateBatch2(SpringWorld build){
        int update = springWorldDao.updateById(build);
        if(true){
            throw new RuntimeException("13");
        }
        return update;
    }

}
