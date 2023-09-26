package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.mjjTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanbang.entity.WorldUser;
import org.wanbang.mapper.WorldUserMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 某个业务服务类
 */
@Service
public class BizService {
    @Autowired
    private BizUnitService bizUnitService;
    @Resource
    private WorldUserMapper userMapper;

    private Map<String, Function<Object, Object>> checkResultDispatcherComX = new HashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    public void checkResultDispatcherComXInit() {
        checkResultDispatcherComX.put("key_订单1", order -> this.bizOne(order));
        checkResultDispatcherComX.put("key_订单1_订单2", order -> bizUnitService.bizTwo(order));
        checkResultDispatcherComX.put("key_订单1_订单2_订单3", order -> bizUnitService.bizThree(order));
    }

    public String getCheckResultComX(String order, int level) {
        //写一段生成key的逻辑：
        String ley = getDispatcherComXKey(order, level);
        System.out.println(ley);

        Function<Object, Object> result = checkResultDispatcherComX.get(ley);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            String apply = (String) result.apply(order);
            return apply;
        }
        return "不在处理的逻辑中返回业务错误";
    }

    /**
     * 判断条件方法
     */
    private String getDispatcherComXKey(String order, int level) {
        StringBuilder key = new StringBuilder("key");
        for (int i = 1; i <= level; i++) {
            key.append("_" + order + i);
        }
        return key.toString();
    }

    public Object bizOne(Object order) {
        WorldUser build1 = WorldUser.builder().name("mjj1").age(1).sex("男").build();
        userMapper.insert(build1);
        return order + "各种花式操作1";
    }
}