package org.wanbang.test.eduorder.dao;

import org.wanbang.test.eduorder.entity.EduOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 财务系统 - 订单表(EduOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-28 20:02:52
 */
public interface EduOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EduOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EduOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param eduOrder 实例对象
     * @return 对象列表
     */
    List<EduOrder> queryAll(EduOrder eduOrder);

    /**
     * 新增数据
     *
     * @param eduOrder 实例对象
     * @return 影响行数
     */
    int insert(EduOrder eduOrder);

    /**
     * 修改数据
     *
     * @param eduOrder 实例对象
     * @return 影响行数
     */
    int update(EduOrder eduOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}