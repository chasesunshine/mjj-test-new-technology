package org.wanbang.constants;

/**
 * 运营中心 统一接口URL constants
 *
 * @author wuweiwei
 * @date 2022-07-05
 */
public interface OperationApiConstants {
    /**
     * DEVICE 微服务名称
     */
    String DEVICE_APP_NAME = "device";

    /**
     * DEVICE API前缀
     */
    String DEVICE_API_PREFIX = "/api/device";

    /**
     * 家庭管理列表
     */
    String OPERATION_API_HOME_MANAGE_LIST = "/home/manage/list";

    /**
     * 说明书管理列表H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_LIST = "/specification/manage/html/list";

    /**
     * 说明书管理列表H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_LIST_OLD = "/specification/manage/html/list/old/{pId}";

    /**
     * 说明书管理列表
     */
    String OPERATION_API_SPECIFICATION_MANAGE_LIST = "/specification/manage/list";

    /**
     * 说明书管理列表
     */
    String OPERATION_API_SPECIFICATION_MANAGE_LIST_OLD = "/specification/manage/list/old";

    /**
     * 说明书上传
     */
    String OPERATION_API_SPECIFICATION_MANAGE_UPLOAD = "/specification/manage/upload";

    /**
     * 说明书上传
     */
    String OPERATION_API_SPECIFICATION_MANAGE_UPLOAD_OLD = "/specification/manage/upload/old";

    /**
     * 说明书新增
     */
    String OPERATION_API_SPECIFICATION_MANAGE_ADD = "/specification/manage/add";

    /**
     * 说明书新增
     */
    String OPERATION_API_SPECIFICATION_MANAGE_ADD_OLD = "/specification/manage/add/old";

    /**
     * 说明书编辑
     */
    String OPERATION_API_SPECIFICATION_MANAGE_EDIT = "/specification/manage/edit";

    /**
     * 说明书编辑
     */
    String OPERATION_API_SPECIFICATION_MANAGE_EDIT_OLD = "/specification/manage/edit/old";

    /**
     * 说明书删除
     */
    String OPERATION_API_SPECIFICATION_MANAGE_DELETE = "/specification/manage/delete/{ids}";

    /**
     * 说明书删除
     */
    String OPERATION_API_SPECIFICATION_MANAGE_DELETE_OLD = "/specification/manage/delete/old/{ids}";

    /**
     * 说明书下载
     */
    String OPERATION_API_SPECIFICATION_MANAGE_DOWNLOAD = "/specification/manage/download/{id}";

    /**
     * 说明书下载地址
     */
    String OPERATION_API_SPECIFICATION_MANAGE_DOWNLOAD_URL = "/specification/manage/download/url";

    /**
     * 说明书下载次数统计&&下载
     */
    String OPERATION_API_SPECIFICATION_MANAGE_DOWNLOAD_COUNT = "/specification/manage/download/count/{id}";

    /**
     * 说明书下载地址H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_DOWNLOAD_URL = "/specification/manage/html/download/url";

    /**
     * 说明书下载地址H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_DOWNLOAD_URL_NEW = "/test/specification/manage/html/download/url";

    /**
     * 说明书下载H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_DOWNLOAD_NEW = "/test/specification/manage/html/download";

    /**
     * 说明书下载H5
     */
    String OPERATION_API_SPECIFICATION_MANAGE_HTML_DOWNLOAD = "/specification/manage/html/download";

    /**
     * 说明书预览
     */
    String OPERATION_API_SPECIFICATION_MANAGE_PREVIEW = "/specification/manage/preview/{id}";

    /**
     * 家庭管理列表详情
     */
    String OPERATION_API_HOME_MANAGE_LIST_DETAIL = "/home/manage/list/detail/{homeId}";

    /**
     * 家庭管理列表设备详情
     */
    String OPERATION_API_HOME_MANAGE_LIST_DEVICE_DETAIL = "/home/manage/list/device/detail";

    /**
     * 根据设备id列表获取所属家庭
     */
    String OPERATION_API_HOME_MANAGE_HOME_INFO = "/home/manage/home/info";

    /**
     * 获取所有房间信息
     */
    String OPERATION_API_HOME_MANAGE_ROOM_INFO = "/home/manage/room/info";

    /**
     * 获取所有数据来源信息
     */
    String OPERATION_API_HOME_MANAGE_DATASOURCE_INFO = "/home/manage/datasource/info";

    /**
     * 获取所有所属家庭信息
     */
    String OPERATION_API_HOME_MANAGE_BELONG_HOME_INFO = "/home/manage/belong/home/info";

    /**
     * 根据集控器deviceKey获取所属家庭信息和家庭下集控器列表
     */
    String OPERATION_API_GET_HOME_CTC_INFO = "/v2/home/manage/get/home/ctc/info";

    /**
     * 根据家庭id获取家庭信息下设备信息
     */
    String OPERATION_API_GET_HOME_DEVICE_INFO = "/v2/home/manage/get/home/device/info";

    /**
     * 根据家庭id获取房间信息以及房间下的设备信息
     */
    String OPERATION_API_GET_HOME_ROOM_DEVICE_INFO = "/v2/home/manage/get/home/room/device/info";

    /**
     * 家庭下设备变更
     */
    String OPERATION_API_HOME_DEVICE_CHANGE = "/home/manage/home/device/change";

    /**
     * 根据家庭id获取家庭信息
     */
    String OPERATION_API_GET_HOME_INFO = "/v2/home/manage/get/home/info";

    /**
     * 修改家庭地址
     */
    String OPERATION_API_EDIT_HOME_ADDRESS = "/v2/home/manage/edit/home/address";


    /**
     * 校验是否存在家庭，不存在则新建家庭
     */
    String OPERATION_API_EXIST_HOME_SAVEHOME = "/v2/home/exist/save/home";

    /**
     * 获取设备统计数量（用于设备数据限制校验）
     */
    String OPERATION_API_HOME_DEVICE_COUNT = "/v2/home/device/count";

    /**
     * 说明书管理 - 文件上传路径
     */
    public static final String HOMEDEVICE_SPECIFICATIONMANAGE = "homedevice/specificationManage/";

    /**
     * redis - 说明书管理 - 上传或者预览key
     */
    public static String DLQ = "home:device:specificationManage:downloadOrPreview";

    /**
     * 说明书新增 - 文件中文名字
     */
    public static final String OPERATION_SPECIFICATIONMANAGE = "运营中心_说明书管理_";

}
