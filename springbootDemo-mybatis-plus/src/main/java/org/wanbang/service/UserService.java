package org.wanbang.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.convert.UserConver;
import org.wanbang.mapper.UserMapper;
import org.wanbang.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wanbang.entity.common.UserVo;
import org.wanbang.entity.common.UserVo1;
import org.wanbang.util.redis.RedisUtils;
import org.wanbang.util.redis.SpringContextHolder;
import org.wanbang.util.spring.SpringUtil;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserConver UserConver;
    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public String selectOne() {
        //redisUtils.set("token","12344");
        stringRedisTemplate.opsForValue().set("token","123443");
        redisTemplate.opsForSet().add("token1","dsadsadsa");

        User user = userMapper.selectOne(Wrappers.<User>query().lambda()
                .eq(User::getId,102));

        UserVo userVo = UserConver.item2Dto(user);

        UserVo1 convert = UserConver.convert(user);

        return JSON.toJSONString(user);
    }


    @Transactional(rollbackFor = Exception.class)
    public String deleteAopTest() {

        User build = User.builder().name("mjj").age(100).sex("男").build();
        int insert = userMapper.insert(build);
        System.out.println("插入成功 "+insert);

        User build1 = User.builder().name("cjj").age(100).sex("男").build();
        // 以下这个用不了
//        UserService userService = (UserService) AopContext.currentProxy();
//        String s = userService.deleteAop(93, build1);
        String s = getService().deleteAop(91, build1);

        return JSON.toJSONString(s);
    }

    /**
     *
     * @return
     */
    // 内层事务可以不加
    //@Transactional(rollbackFor = Exception.class)
    public String deleteAop(Integer id,User user) {
        int delete = userMapper.deleteById(id);
        System.out.println("deleteAop 删除成功 " + delete);

        int insert = userMapper.insert(user);
        System.out.println("deleteAop 插入成功 "+insert);

        return JSON.toJSONString(user);
    }

    // https://blog.csdn.net/mameng1988/article/details/85548812
    //解决事务失效
    private UserService getService(){
        return SpringUtil.getBean(this.getClass());   //SpringUtil工具类见下面代码
    }
}
