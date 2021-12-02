package org.wanbang.common.enums;

public enum CacheNameEnum {

    /**
     * 服务节点Id
     */
    SVC_NODE_ID("svc-node-id"),

    /**
     * 凭证信息
     */
    SAFETY_AUTH("token:%s"),

    /**
     * 客户端凭证信息
     */
    CLIENT_AUTH("client:token:%s"),

    /**
     * 安全策略(openid)
     **/
    SAFETY_RULE_OPENID("safety-rule:openid:%s"),

    /**
     * 安全策略(ip)
     **/
    SAFETY_RULE_IP("safety-rule:ip:%s"),

    /**
     * 安全策略(手机号)
     **/
    SAFETY_RULE_USER_TEL("safety-rule:user-tel:%s"),

    /**
     * 安全策略(userid-order)
     **/
    SAFETY_RULE_USER_ID_ORDER("safety-rule:user-id-order:%d"),
    /**
     * 安全策略（控制调用实名认证接口频率）
     */
    SAFETY_RULE_ORDERID_CHECK_IDCARD("safety-rule:orderid-check-idcard:%d"),


    /**
     * 埋点日志消费队列
     */
    QUEUE$TRACE_LOG("sensors:logs:%s"),

    /**
     * 订单状态锁
     */
    LOCK$ORDER_STATUS("lock:order:status:%d"),

    /**
     * 用户注册锁
     */
    LOCK$USER_REGISTER("lock:user:register:%s"),

    /**
     * 定时任务执行接种提醒锁
     */
    LOCK$NOTIFY_VACCINE("notify:vaccine:%d"),

    /**
     * 保存MQ已消费的消息ID,避免重复消费
     */
    LOCK$MQ_MSG_ID("mq:msg-id:%s"),

    /**
     * 渠道平台订单批量导入锁
     */
    LOCK$PLATFORM_ORDER_IMPORT("lock:platform:order:import"),

    /**
     * 保存首页第N阶段
     */
    CONFIG$INDEX_STAGE("index:stage"),

    /**
     * 保存pov的商盟的配置
     */
    CONFIG$POV_ID("sumpayconfig:pov-id:%d"),

    /**
     * 保存每天预约号占用池
     */
    CONFIG$RESERVE_NO("reserve-no:%s"),

    /**
     * 港澳未通知用户定时发送消息
     */
    LOCK$REGISTER("notify:register:%d"),

    /**
     * 企业订单发送短信任务
     */
    LOCK$CUSTOMER_ORDER_SMS("order:share-benefit:%d"),

    /**
     * 预约号分片存储命名
     */
    POV_RESERVENO$SEGMENT_ID("reserveNo:pov-id:%d"),

    /**
     * 用户海报邀请相关信息
     */
    INVITE_POSTER$USER_ID("poster:user-id:%s"),
    /**
     * 渠道二维码邀请相关信息
     */
    INVITE_QRCODE$USER_ID("qrcode:user-id:%s"),

    /**
     * 文章详情id
     */
    ARTICLE_INFO_ID("article-info-id-v2:%d"),
    /**
     * 文章内容
     */
    ARTICLE_INFO_CONTENT("article-info-content"),
    /**
     * 文章基本信息
     */
    ARTICLE_INFO_BASE_INFO("article-info-base-info"),
    /**
     * 文章真实阅读数量
     */
    ARTICLE_INFO_READ_COUNT("article-info-read-count"),
    /**
     * 文章分页id
     */
    ARTICLE_INFO_PAGE("article-info-page:%s"),
    /**
     * 科普文章存储
     */
    CONVERT_TO_OSS_REDIS_PRE_KEY("convert-to-oss-file:%s"),

    /**
     * 文章详情id
     */
    NUCLEIC_DAZD_HOSPITAL_CODE("nucleic-dazd-hospital-code:%s"),

    /**
     * 核酸预约机构
     */
    NUCLEIC_SUBSCRIBE_ORGAN_CITY_CODE("nucleic-subscribe-organ:city-code:%s"),

    /**
     * 核酸预约机构
     */
    NUCLEIC_SUBSCRIBE_ORGAN_HOSPITAL_ID("nucleic-subscribe-organ:hospital-id:%s"),

    /**
     * 核酸预约机构最后拉取时间-金域
     */
    NUCLEIC_KINGMED_ORGAN_LAST_TIME("nucleic-kingmed-organ:last-time"),

    /**
     * 核酸预约项目最后拉取时间-金域
     */
    NUCLEIC_KINGMED_PRODUCT_LAST_TIME("nucleic-kingmed-product:last-time"),

    /**
     * 24好玩 获取游戏基本配置
     */
    HAOWAN_GAME_CONFIG_INFO("haowan-game-config:game-id:%s"),

    /**
     * 已订阅用户userID
     */
    USER_APPOINT_VACCINE("user-appoint-vaccine:%d"),

    /**
     * 点击角标用户信息
     */
    USER_INFO_CLICK_CORNERMARK("user-info-click-cornermark:%s"),

    /**
     * 24好玩用户Id映射
     */
    HW24_UID_MAP("24haowan:user:uid-map:%d"),

    /**
     * 24好玩游戏信息
     */
    HW24_GAME_INFO("24haowan:game-info:%s"),

    /**
     * 中保商品分类查询接口修改时间
     */
    GOODSSTRU_LAST_TIME("goodsstru-last-time"),

    /**
     * ID生成锁
     */
    SERIAL_NO_LOCK("lock:serial-no"),

    /**
     * 物料编码生成
     */
    MATERIAL_NO("material-no"),
    /**
     * 物料编码生成锁
     */
    MATERIAL_NO_LOCK("lock:material-no"),
    /**
     * 物料编码生成
     */
    MATERIAL_NO_SET("material-no-set");

    private final String pattern;

    CacheNameEnum(String pattern) {
        this.pattern = pattern;
    }

    public String formatOrgId(String orgId) {
        return this.pattern+orgId;
    }

}
