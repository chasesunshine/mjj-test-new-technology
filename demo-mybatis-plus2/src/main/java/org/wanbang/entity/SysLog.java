package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_log")
@Builder
public class SysLog {

    private long id;

    private String uri;

    private String daoMethodName;

    private String ip;

    private String wholeSql;

    private String remark;

    private LocalDateTime createDate;
}

