package org.wanbang.common.constant;

import java.math.BigDecimal;
import java.time.Duration;

/**
 * 公共常量定义
 *
 * @author xiongmw@wbpharma.com
 * @version 1.0
 */
public interface CommonConsts {

    /**
     * 日期时间格式
     **/
    String FORMAT_PATTERN_DATA = "yyyy-MM-dd";
    String FORMAT_PATTERN_DATA_TIME = "yyyy-MM-dd HH:mm:ss";
    String FORMAT_PATTERN_DATA_MIN = "yyyy-MM-dd HH:mm";

    /**
     * 验证码时长
     */
    long SMS_CODE_EXPIRE = 300;
    /**
     * 验证码长度
     */
    int SMS_CODE_CHAR_CT = 6;

    /**
     * 缓存相关的
     **/
    String CACHE_KEY_PREFIX = "ym";

    /**
     * 成功返回码
     */
    String SUCCESSFUL_CODE_ZERO = "0";

    /**
     * 默认空主键值
     */
    Long EMPTY_PK_VAL = 0L;

    /**
     * 默认空主键值
     */
    Long EMPTY_LONG_VAL = 0L;

    /**
     * token失效时间
     */
    Duration TOKEN_TTL = Duration.ofHours(8);

    /**
     * token请求头信息
     **/
    String TOKEN_HEADER_NAME = "x-auth-token";
    /**
     * 场景值定义
     **/
    String SCENE_HEADER_NAME = "x-client-scene";

    /**
     * 距离单位
     */
    String DISTANCE_METER = "m";
    String DISTANCE_KILOMETER = "km";
    BigDecimal DISTANCE_THOUSAND = new BigDecimal(1000);
}
