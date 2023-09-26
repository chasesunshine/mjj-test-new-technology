package org.wanbang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.wanbang.entity.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    int insertLog(SysLog sysLog);
}
