package org.wanbang.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.wanbang.entity.WorldUser;
import org.wanbang.mapper.WorldUserMapper;

import javax.annotation.Resource;

@Service
@Slf4j
public class WorldUserService {
    @Resource
    private WorldUserMapper userMapper;

    public String selectOne() {
        WorldUser worldUser = userMapper.selectOne(Wrappers.<WorldUser>query().lambda()
                .eq(org.wanbang.entity.WorldUser::getId, 13));

        return JSON.toJSONString(worldUser);
    }

    public Integer insertOnedata(String name,Integer age) {
        int mjj = userMapper.insertOneData(WorldUser.builder().name(name).age(age).build());
        return mjj;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insert(String name,Integer age) {
        int mjj = userMapper.insert(WorldUser.builder().name(name).age(age).build());

        if(true){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return mjj;
    }


    public Integer insert1(String name,Integer age) {
        int mjj = userMapper.insert(WorldUser.builder().name(name).age(2).build());

        if(true){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return mjj;
    }

    @Transactional(rollbackFor = Exception.class)
    public String selectTwo() {
        WorldUser build1 = WorldUser.builder().name("mjj1").age(2).sex("男").build();
        WorldUser build2 = WorldUser.builder().name("lj2").age(3).sex("xxx").build();
        userMapper.insert(build1);

        // 只需要方法外部加事务即可
        asnRewrite(userMapper,build2);
        return "s";
    }

    private void asnRewrite(WorldUserMapper userMapper, WorldUser build2) {
        userMapper.insert(build2);
    }

}
