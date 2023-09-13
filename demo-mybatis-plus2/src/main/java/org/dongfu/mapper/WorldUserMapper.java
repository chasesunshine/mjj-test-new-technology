package org.dongfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dongfu.entity.WorldUser;

public interface WorldUserMapper extends BaseMapper<WorldUser> {

    int insertOneData(WorldUser mjj);
}