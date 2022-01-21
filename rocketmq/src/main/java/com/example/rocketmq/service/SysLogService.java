package com.example.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.rocketmq.entity.SysLog;
import com.example.rocketmq.mapper.SysLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    public String selectOne() {
        SysLog sysLog = sysLogMapper.selectOne(Wrappers.<SysLog>query().lambda()
                .eq(SysLog::getId, 1));

        return JSON.toJSONString(sysLog);
    }
}
