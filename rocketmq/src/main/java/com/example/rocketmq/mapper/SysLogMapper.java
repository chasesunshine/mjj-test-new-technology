package com.example.rocketmq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rocketmq.entity.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    int insertLog(SysLog sysLog);
}
