package org.dongfu.config.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * rpc r认证配置
 *
 * @author lijun
 * @createTime 2022年02月21日 17:55:34
 */
@Getter
@Setter
public class AuthDto {

    /**
     * 客户端 key
     */
    private String clientKey;

    /**
     * 客户端 secret
     */
    private String clientSecret;
}
