package org.wanbang.service;


import org.wanbang.entity.SpringStudy;

/**
 * (SpringStudy)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 10:17:42
 */
public interface SpringStudyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SpringStudy queryById(Long id);
}
