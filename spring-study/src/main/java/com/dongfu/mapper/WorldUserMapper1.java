package com.dongfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongfu.entity.WorldUser1;

public interface WorldUserMapper1 extends BaseMapper<WorldUser1> {

    WorldUser1 selectData();
}