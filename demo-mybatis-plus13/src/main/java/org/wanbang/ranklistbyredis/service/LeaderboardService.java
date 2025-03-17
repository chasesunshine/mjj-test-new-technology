package org.wanbang.ranklistbyredis.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class LeaderboardService {

    public static final String LEADERBOARD_KEY = "leaderboard"; // 排行榜key

    @Resource
    private StringRedisTemplate stringRedisTemplate; // Redis模板

    /**
     * 添加用户及其得分到排行榜
     */
    public void addUserToLeaderboard(String userId, double score) {
        stringRedisTemplate.opsForZSet().add(LEADERBOARD_KEY, userId, score);
    }

    /**
     * 获取前N名用户
     */
    public Set<String> getTopUsers(int n) {
        return stringRedisTemplate.opsForZSet().reverseRange(LEADERBOARD_KEY, 0, n - 1);
    }

    /**
     * 获取某个用户的排名
     */
    public Long getUserRank(String userId) {
        return stringRedisTemplate.opsForZSet().reverseRank(LEADERBOARD_KEY, userId);
    }

    /**
     * 获取某个用户的得分
     */
    public Double getUserScore(String userId) {
        return stringRedisTemplate.opsForZSet().score(LEADERBOARD_KEY, userId);
    }

    /**
     * 获取用户的排名和得分
     */
    public Map<String, Object> getUserRankAndScore(String userId) {
        Map<String, Object> result = new HashMap<>();
        result.put("rank", getUserRank(userId));
        result.put("score", getUserScore(userId));
        return result;
    }
}

