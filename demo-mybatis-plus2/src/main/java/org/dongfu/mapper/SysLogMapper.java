package org.dongfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dongfu.entity.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    int insertLog(SysLog sysLog);
}
