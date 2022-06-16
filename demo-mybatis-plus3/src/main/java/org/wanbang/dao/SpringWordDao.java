package org.wanbang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wanbang.entity.SpringWord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
public interface SpringWordDao extends BaseMapper<SpringWord> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SpringWord queryById(Long id);

}

