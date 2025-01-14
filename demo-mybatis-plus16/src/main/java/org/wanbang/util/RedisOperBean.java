package org.wanbang.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(name="redisTemplate")
public class RedisOperBean {

}
