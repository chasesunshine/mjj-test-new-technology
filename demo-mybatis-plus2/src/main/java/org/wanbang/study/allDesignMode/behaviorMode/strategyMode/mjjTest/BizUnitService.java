package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.mjjTest;

import org.springframework.stereotype.Service;
import org.wanbang.entity.WorldUser;
import org.wanbang.mapper.WorldUserMapper;

import javax.annotation.Resource;

/**
 * 提供业务逻辑单元
 */
@Service
public class BizUnitService {

    @Resource
    private WorldUserMapper worldUserMapper;

    public Object bizOne(Object order) {
        WorldUser build1 = WorldUser.builder().name("mjj1").age(1).sex("男").build();
        worldUserMapper.insert(build1);
        return order + "各种花式操作1";
    }

    public Object bizTwo(Object order) {
        WorldUser build1 = WorldUser.builder().name("mjj2").age(2).sex("男").build();
        worldUserMapper.insert(build1);
        return order + "各种花式操作2";
    }

    public Object bizThree(Object order) {
        WorldUser build1 = WorldUser.builder().name("mjj3").age(3).sex("男").build();
        worldUserMapper.insert(build1);
        return order + "各种花式操作3";
    }
}
