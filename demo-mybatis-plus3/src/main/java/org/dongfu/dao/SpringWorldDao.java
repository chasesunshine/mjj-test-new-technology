package org.dongfu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dongfu.entity.SpringWorld;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
public interface SpringWorldDao extends BaseMapper<SpringWorld> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SpringWorld queryById(Long id);

}

