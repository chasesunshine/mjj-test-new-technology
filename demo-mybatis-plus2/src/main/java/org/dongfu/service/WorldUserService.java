package org.dongfu.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.dongfu.entity.WorldUser;
import org.dongfu.mapper.WorldUserMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class WorldUserService {
    @Resource
    private WorldUserMapper userMapper;

    public String selectOne() {
        WorldUser worldUser = userMapper.selectOne(Wrappers.<WorldUser>query().lambda()
                .eq(org.dongfu.entity.WorldUser::getId, 1));

        return JSON.toJSONString(worldUser);
    }

    public Integer insertOnedata(String name,Integer age) {
        int mjj = userMapper.insertOneData(WorldUser.builder().name(name).age(age).build());
        return mjj;
    }

    public Integer insetOneMybatisTest() {
        log.info("测试数据库");
        List<WorldUser> worldUsers = new ArrayList<>();
        WorldUser build = WorldUser.builder().name("12345").age(1).build();
        WorldUser build1 = WorldUser.builder().name("1234567891011123").age(1).build();
        WorldUser build2 = WorldUser.builder().name("123456789").age(1).build();
        worldUsers.add(build);
        worldUsers.add(build1);
        worldUsers.add(build2);

        for (int i = 0; i < worldUsers.size(); i++) {
            try {
                Integer integer = insetOneMybatisTest1(worldUsers.get(i));
            }catch (Exception e){
                log.info("错误");
            }
        }
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insetOneMybatisTest1(WorldUser worldUser) {
        int i = userMapper.insertOneData(worldUser);
        return i;
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

    public String insetData(WorldUser worldUser) {
        int insert = userMapper.insert(worldUser);
        return String.valueOf(insert);
    }
}
