package org.wanbang.service;

/**
 * (SpringWord)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 10:17:42
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    String queryById(Long id);
}
