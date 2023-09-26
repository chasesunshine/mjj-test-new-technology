package org.wanbang.study.redisLock.utils;


/**
 * 订单异常定义
 *
 * @author xiongmw@wbpharma.com
 * @version 1.0
 */
public interface CommonErrorCode {

    MessageCode A401 = MessageCode.build(401, "无效的时间段，不可设置号源");

    /*** 系统内部基础模块 11000 开始**/
    MessageCode TOKEN_NOT_FIND = MessageCode.build(11001, "对象不能为空或当前用户暂未生成凭证");
    MessageCode TOKEN_INVALID = MessageCode.build(11001, "当前凭证已失效");
    MessageCode DATA_TO_DB_ERROR = MessageCode.build(11002, "数据保存入库失败");
    MessageCode DATE_PARSE_ERROR = MessageCode.build(11004, "日期格式不正确");
    MessageCode LOCK_TIMEOUT = MessageCode.build(11005, "业务处理超时");
    MessageCode PARAM_NULL_ERROR = MessageCode.build(11009, "参数为空");
    MessageCode PARAM_ERROR = MessageCode.build(11010, "非法参数");
    MessageCode GET_LOCK_ERROR = MessageCode.build(11011, "获取锁失败");
    MessageCode SYSTEM_ERROR = MessageCode.build(11012, "系统错误");
    MessageCode AUTH_ERROR = MessageCode.build(11013, "权限错误");

    /*** 系统外部依赖-微信相关 12000 开始**/
    MessageCode WX_API_ERROR = MessageCode.build(12000, "微信服务繁忙");
    MessageCode WX_CODE_EMPTY = MessageCode.build(12002, "code不能为空");
    MessageCode WX_ACCESS_TOKEN_ERROR = MessageCode.build(12003, "无法获取微信accessToken");
    MessageCode WX_ACCESS_TOKEN_URL_EMPTY = MessageCode.build(12003, "accessTokenUrl参数不能为空");

    /*** 履约单相关 **/
    MessageCode FULFILL_ORDER_NOT_EXIST = MessageCode.build(13001, "履约单不存在");
    MessageCode FULFILL_ORDER_UNABLE_CANCEL = MessageCode.build(13002, "履约单已核销不能取消");
    MessageCode FULFILL_ORDER_UNAVAILABLE = MessageCode.build(13003, "履约单不能进行预约");
    MessageCode FULFILL_ORDER_SUBMIT_REPEAT = MessageCode.build(13004, "履约单不能重复提交");
    MessageCode FULFILL_ORDER_OWNER_NOT_MATCH = MessageCode.build(13005, "履约单不属于当前登录人");
    MessageCode FULFILL_ORDER_STORE_NOT_MATCH = MessageCode.build(13000, "履约单不属于当前门店");
    MessageCode NUM_STOCK_NOT_ENOUGH = MessageCode.build(13006, "号源库存不足");
    MessageCode FULFILL_ORDER_VAL_CODE_UNVALID = MessageCode.build(13007, "核销码不合法");

    MessageCode FULFILL_ITEM_NOT_EXIST = MessageCode.build(13008, "履约明细单不存在");
    MessageCode FULFILL_ITEM_UNABLE_TO_VERIFY_BY_STATUS = MessageCode.build(13009   , "履约明细单状态不是预约成功状态不能进行核销");
    MessageCode FULFILL_ITEM_UNABLE_TO_VERIFY_BY_STORE  = MessageCode.build(13010   , "履约明细单不是匹配的门店不能进行核销");
    MessageCode FULFILL_ITEM_UNABLE_TO_VERIFY_BY_VAL_CODE  = MessageCode.build(13019   , "履约明细单核销码错误不能进行核销");
    MessageCode FULFILL_ITEM_UNABLE_TO_VERIFY_BY_DATE  = MessageCode.build(13011   , "履约明细单未到时间不能进行核销");

    MessageCode FULFILL_ITEM_UNABLE_TO_CHANGE_DATE_BY_STATUS  = MessageCode.build(13012   , "履约明细单不是预约成功或者预约中状态不能改期");
    MessageCode FULFILL_ITEM_UNABLE_TO_CHANGE_DATE_BY_STORE  = MessageCode.build(13013   , "履约明细单门店不匹配不能改期");
    MessageCode FULFILL_ITEM_UNABLE_TO_CHANGE_DATE_BY_STAGE  = MessageCode.build(13014   , "履约明细单当前阶段不能改期");
    MessageCode FULFILL_ITEM_UNABLE_TO_CHANGE_DATE_BY_SAME_STOCK  = MessageCode.build(13020   , "履约明细单号源库存一致");

    MessageCode FULFILL_ITEM_UNABLE_TO_CANCEL_BY_STATUS  = MessageCode.build(13015   , "履约明细单当前状态不能取消");
    MessageCode FULFILL_ITEM_UNABLE_TO_CONFIRM_BY_STATUS  = MessageCode.build(13017   , "履约明细单当前状态不能确认");
    MessageCode ID_NO_INVALID  = MessageCode.build(13018   , "身份证号码格式错误");
    MessageCode ID_CERTIFICATED_IN_PASSED  = MessageCode.build(13019   , "证件信息错误请重新填写");

    MessageCode FULFILL_ITEM_LIST_NOT_EXIST = MessageCode.build(13016, "履约单明细不存在");
    MessageCode ITEM_NOT_EXIST = MessageCode.build(13021, "商品配置不存在");

    MessageCode FULFILL_ITEM_VERIFIED = MessageCode.build(13022, "重复核销");

    /** 商城商品rpc相关 13000 **/
    MessageCode ITEM_SERVICE_ERROR = MessageCode.build(13000, "商城商品服务繁忙");
    MessageCode API_ERROR = MessageCode.build(11010, "服务繁忙");

    /** 验证码相关  **/
    MessageCode SMS_CODE_CHECK_ERROR = MessageCode.build(14000, "短信验证码错误或者已失效");

    /** 库存相关 15000 */
    MessageCode NONE_STOCK = MessageCode.build(15000, "无库存");
    MessageCode NO_STOCK_SET = MessageCode.build(15001, "无可设置号源信息");
    MessageCode EXPIRE_PERIOD = MessageCode.build(15002, "无效的时间段，不可设置号源");
}
