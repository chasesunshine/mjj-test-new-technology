package org.wanbang.config.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 操作记录配置
 *
 * @author lijun
 */
@Getter
@Setter
public class AuthProperties {

    /**
     * 认证信息
     */
    private List<AuthDto> authList;

    /**
     * 需要认证的路径
     */
    private List<String> paths;
}
