package org.wanbang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.wanbang.service.VisitStatisticsService;

import java.time.LocalDate;

@Service
public class VisitStatisticsServiceImpl implements VisitStatisticsService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String TOTAL_VISITS_KEY = "stat:visits:total";
    private static final String DAILY_VISITS_KEY_PREFIX = "stat:visits:daily:";

    /**
     * 记录用户访问
     * @param userId 用户ID
     */
    @Override
    public void recordVisit(String userId) {
        // 总访问量+1
        redisTemplate.opsForValue().increment(TOTAL_VISITS_KEY);

        // 每日访问量+1
        String todayKey = DAILY_VISITS_KEY_PREFIX + LocalDate.now().toString();
        redisTemplate.opsForValue().increment(todayKey);

        // 记录用户访问(可选)
        if (userId != null) {
            String userVisitsKey = "stat:user:visits:" + userId;
            redisTemplate.opsForZSet().incrementScore(userVisitsKey, LocalDate.now().toString(), 1);
        }
    }

    /**
     * 获取总访问量
     */
    @Override
    public long getTotalVisits() {
        String value = redisTemplate.opsForValue().get(TOTAL_VISITS_KEY);
        return value == null ? 0 : Long.parseLong(value);
    }

    /**
     * 获取某天的访问量
     */
    @Override
    public long getDailyVisits(LocalDate date) {
        String key = DAILY_VISITS_KEY_PREFIX + date.toString();
        String value = redisTemplate.opsForValue().get(key);
        return value == null ? 0 : Long.parseLong(value);
    }
}
