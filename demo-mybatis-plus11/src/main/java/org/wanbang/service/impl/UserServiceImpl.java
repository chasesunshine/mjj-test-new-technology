package org.wanbang.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Service;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private CacheManager cacheManager;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        log.info("通过ID查询单条数据");
        return this.userDao.selectById(id);
    }

    /**
     * @Cacheable 注解用于标记一个方法，表示该方法的结果应该被缓存。当方法被调用时，Spring 会首先检查缓存中是否存在对应的值。
     * 如果存在，则直接返回缓存中的值；如果不存在，则执行方法并将结果存入缓存。
     *
     * 参数说明
     * value 或 cacheNames：指定缓存的名称。
     * key：指定缓存的键，可以使用 SpEL 表达式。
     * unless：指定一个条件，如果条件为 true，则不将结果存入缓存。
     * condition：指定一个条件，如果条件为 true，则执行缓存逻辑。
     *
     * @param userId
     * @return
     */
    @Cacheable(value = "users", key = "#userId", unless = "#result == null")
    public User getUserById(Long userId) {
        // 模拟从数据库中查询数据
        System.out.println("Fetching user from database...");
        return new User(userId, "User" + userId);
    }

    /**
     * @CachePut 注解用于标记一个方法，表示该方法的结果应该被存入缓存，但无论缓存中是否存在对应的值，都会执行方法体。通常用于更新缓存中的数据。
     *
     * 参数说明
     * value 或 cacheNames：指定缓存的名称。
     * key：指定缓存的键，可以使用 SpEL 表达式。
     * unless：指定一个条件，如果条件为 true，则不将结果存入缓存。
     * condition：指定一个条件，如果条件为 true，则执行缓存逻辑。
     *
     * @param user
     * @return
     */
    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        // 模拟更新数据库中的用户信息
        System.out.println("Updating user in database...");
        return user;
    }

    /**
     * @CacheEvict 注解用于标记一个方法，表示该方法执行后应该从缓存中移除指定的条目。通常用于删除缓存中的数据。
     *
     * 参数说明
     * value 或 cacheNames：指定缓存的名称。
     * key：指定缓存的键，可以使用 SpEL 表达式。
     * allEntries：如果为 true，则清除所有缓存条目。
     * beforeInvocation：如果为 true，则在方法调用之前清除缓存条目，默认为 false。
     *
     * @param userId
     */
    @CacheEvict(value = "users", key = "#userId")
    public void deleteUser(Long userId) {
        // 模拟从数据库中删除用户
        System.out.println("Deleting user from database...");
    }

    /**
     * 获取 caffeine 缓存全部信息
     * @return
     */
    @Override
    public String getAllCaffeineCache() {
        Map<String, Object> allCachesData = new HashMap<>();
        for (String cacheName : cacheManager.getCacheNames()) {
            CaffeineCache cache = (CaffeineCache) cacheManager.getCache(cacheName);
            allCachesData.put(cacheName, cache.getNativeCache().asMap());
        }
        return JSON.toJSONString(allCachesData);
    }

}
