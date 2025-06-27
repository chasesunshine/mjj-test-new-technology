package org.wanbang.wxsportstep;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Tuple;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/wx/sport")
public class WxSportController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public void test(){

//        redisTemplate.opsForZSet().remove("steps:rank:20230601","马佳健1","马佳健2","马佳健3","马佳健4","马佳健5");

        // 准备要添加的数据
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
        tuples.add(new DefaultTypedTuple<>("马佳健6", 6000.0));
        tuples.add(new DefaultTypedTuple<>("马佳健7", 7000.0));
        tuples.add(new DefaultTypedTuple<>("马佳健8", 8000.0));
        redisTemplate.opsForZSet().add("steps:rank:20230601", tuples);

        redisTemplate.opsForZSet().add("steps:rank:20230601","马佳健1",1000);
        redisTemplate.opsForZSet().add("steps:rank:20230601","马佳健3",3000);
        redisTemplate.opsForZSet().add("steps:rank:20230601","马佳健2",2000);
        redisTemplate.opsForZSet().add("steps:rank:20230601","马佳健5",5000);
        redisTemplate.opsForZSet().add("steps:rank:20230601","马佳健4",4000);

        // 获取用户自己的排名和步数
        Long rank = redisTemplate.opsForZSet().rank("steps:rank:20230601", "马佳健3")+1;
        Double score = redisTemplate.opsForZSet().score("steps:rank:20230601", "马佳健2");
        // 获取TOP N排行榜
        Set<Tuple> topUsers = redisTemplate.opsForZSet().reverseRangeWithScores("steps:rank:20230601", 0, 2);
        // 获取第M页数据，每页N条
        int pageNum = 1;
        int pageSize = 3;
        int start = (pageNum - 1) * pageSize;
        int end = start + pageSize - 1;
        Set<Tuple> pageData = redisTemplate.opsForZSet().reverseRangeWithScores("steps:rank:20230601", start, end);


        System.out.println("排名"+ rank);
        System.out.println("步数"+ score);
        System.out.println("TOP N排行榜"+ JSON.toJSONString(topUsers));
        System.out.println("获取第M页数据，每页N条"+ JSON.toJSONString(pageData));

    }
}
