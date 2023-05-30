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
import org.wanbang.util.common.CallBack;
import org.wanbang.util.redis.RedisUtils;
import org.wanbang.util.redis.lock.LockExecutor;
import org.wanbang.util.spring.SpringUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

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
    @Resource(name = "redisStringTemplate")
    private RedisTemplate redisTemplate;
    @Resource
    private LockExecutor lockExecutor;

    public String TestRedisson() throws Exception {
        User user = new User();
        String a = "1";
        String mjj1 = lockExecutor.exec("token", 3, () -> {

            return "1";
        });
        return null;
    }

    public String selectOne() {
        //redisUtils.set("token","12344");
        // redis - String
        stringRedisTemplate.opsForValue().set("token","123443");
        System.out.println("redis - String:"+stringRedisTemplate.opsForValue().get("token"));

        // redis - Set
        String mjj = String.format("mjj:mjj1:fxjk");
        redisTemplate.opsForSet().add(mjj,"dsadsadsa123");
        redisTemplate.opsForSet().add(mjj,"dsadsadsaxxx");
        redisTemplate.opsForSet().add(mjj,"dsadsadsaxxx");
        String mjj1 = String.format("mjj:mjj1:fxyjk");
        redisTemplate.opsForSet().add(mjj1,"dsadsadsa123");
        redisTemplate.opsForSet().add(mjj1,"dsadsadsaxxx");
        Boolean dsadsadsa123 = redisTemplate.opsForSet().isMember(mjj, "dsadsadsa123");
        Boolean dsadsadsa12 = redisTemplate.opsForSet().isMember(mjj, "dsadsadsa12");
        Set<String> resultSet = redisTemplate.opsForSet().members(mjj);
        System.out.println("redis-set-isMember: "+dsadsadsa123);
        System.out.println("redis-set-isMember: "+dsadsadsa12);
        System.out.println(resultSet.toString());

//        // redis - Zset
//        String mjj2 = String.format("fxjk");
//        Set<String > set = new TreeSet<>();
//        set.add("dsadsadsa123");
//        set.add("dsadsadsaxxx");
//        redisTemplate.opsForZSet().add(mjj2,set);


        //redis - Hashmap
        redisTemplate.opsForHash().put("Person","name","ligang");
        redisTemplate.opsForHash().put("Person","age","31");
        redisTemplate.opsForHash().put("Person","slary",10000);
        redisTemplate.opsForHash().put("Person1","name1","ligang1");
        redisTemplate.opsForHash().put("Person1","age1","311");
        redisTemplate.opsForHash().put("Person1","slary1",100001);
        Object mapValue = redisTemplate.opsForHash().get("Person","age");  //31
        List person = redisTemplate.opsForHash().values("Person");
        // hash类型设置过期时间
        boolean b = redisTemplate.expire("Person", 30, TimeUnit.SECONDS);
        System.out.println("redis - hashmap - allValue : " + person.toString());
        System.out.println("通过get(H key, Object hashKey)方法获取map键的值:" + mapValue);

        //redis - List
        redisTemplate.opsForList().leftPush("list",new User().setId(1).setName("1"));
        redisTemplate.opsForList().leftPush("list",new User().setId(2).setName("2"));
        redisTemplate.opsForList().leftPush("list",new User().setId(3).setName("3"));
        String listValue = redisTemplate.opsForList().index("list",1) + "";
        System.out.println("通过index(K key, long index)方法获取指定位置的值:" + listValue);


        User user = userMapper.selectOne(Wrappers.<User>query().lambda()
                .eq(User::getId,102));

        UserVo userVo = UserConver.item2Dto(user);

        UserVo1 convert = UserConver.convert(user);

        return JSON.toJSONString(user);
    }

    public String selectOne1() {
        User user = userMapper.selectOne(Wrappers.<User>query().lambda()
                .eq(User::getId,102));

        user.setOrgId("111");
        // 转换的时候不会  转换与映射继承的类的成员变量
        UserVo userVo = UserConver.item2Dto(user);
        UserVo1 convert = UserConver.convert(user);

        return JSON.toJSONString(user);
    }

    /**
     * 测试延时队列
     * @return
     */
    public String delayQueue() {
        stringRedisTemplate.opsForValue().set("token1","123443",3, TimeUnit.SECONDS);
        redisTemplate.opsForHash().put("Person","name","ligang");
        redisTemplate.expire("Person",5,TimeUnit.SECONDS);
        return "1";
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

    @Transactional(rollbackFor = Exception.class)
    public String deleteAopTest1() {

        List<User> userLiat = getMaterialNo(sex-> userMapper.selectUserList(sex));

        return JSON.toJSONString(userLiat);
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

    public static List<User> getMaterialNo(CallBack callBack){
        List<User> userList = callBack.selectUserList("男");
        return userList;
    }

}
