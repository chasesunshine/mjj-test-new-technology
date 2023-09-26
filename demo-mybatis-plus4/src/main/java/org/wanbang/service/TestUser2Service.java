package org.wanbang.service;

import org.wanbang.entity.TestUser2;

/**
 * (SpringWord)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 10:17:42
 */
public interface TestUser2Service {

    TestUser2 queryById(Long id);

    Integer insertOne();
}
