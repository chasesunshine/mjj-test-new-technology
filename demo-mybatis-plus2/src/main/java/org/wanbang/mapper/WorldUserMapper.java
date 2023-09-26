package org.wanbang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wanbang.entity.WorldUser;

public interface WorldUserMapper extends BaseMapper<WorldUser> {

    int insertOneData(WorldUser mjj);
}