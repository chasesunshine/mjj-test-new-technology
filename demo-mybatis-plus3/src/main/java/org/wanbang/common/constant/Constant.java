package org.wanbang.common.constant;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijun
 */
public final class Constant {
    /**
     * 内部仓
     */
    public static final Integer PLARFORM_IN = 0;

    /**
     * 外部仓
     */
    public static final Integer PLARFORM_OUT = 1;

    /**
     * 云仓
     */
    public static final Integer PLARFORM_CLOUD = 2;

    /**
     * 代发仓
     */
    public static final Integer PLARFORM_DROP_SHIPPING = 3;

    /**
     * PMS手动入库单回写
     */
    public static final String PMS_ASN_BACKREWRITE = "pmsAsnBackrewrite";

    /**
     * PMS手动采购退货单出库单回写
     */
    public static final String PMS_RTV_BACKREWRITE = "pmsRtvBackrewrite";

    /**
     * 养护类型
     */
    public static final List<String> CURING_CYCLE_LIST = Arrays.asList("普通养护", "重点养护", "无需养护");

    /**
     * 发送邮件状态：0-未发送 1-已发送 2-发送失败
     */
    public static final Integer NOT_SEND = 0;
    public static final Integer ALREADY_SEND = 1;
    public static final Integer FAIL_SEND = 2;


    public static final String YES = "是";
    public static final String NO = "否";
    public static final String FALSE = "false";

    public static final int MAX_TRY_TIMES = 50;

    public static final String STR_0 = "0";
    public static final String STR_1 = "1";
    public static final String EXPORT = "export";
    public static final String OSS = "oss";
    public static final String FILE = "file";
    public static final String ERROR = "/error";
    public static final String DEVOPS = "devops";
    public static final String COMMON = "/api/common";

    public static final String ERP = "erp";
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String COMMA = ",";
    public static final String QES_MARK = "?";
    public static final String EXCEL_SUFFIX = ".xlsx";
    public static final String YEAR = "年";
    public static final String MONTH = "月";
    public static final String UNKNOWN = "unknown";
    public static final String UNDEFINED = "undefined";
    public static final String DICT_NOT_USE = " 字典未启用";
    public static final String FILE_CACHE = "fileCache";
    public static final String USER_CACHE = "userCache";
    public static final String NULL = "null";
    public static final String PASSWORD_AES_KEY = "pms@2021pms@2021";
    public static final String ORG_ID = "orgId";
    public static final String USER_NAME = "userName";
    public static final String NICK_NAME = "nickname";
    public static final String TOKEN = "token";
    public static final String IS_SRM = "isSRM";
    public static final String DEFAULT = "default";
    public static final String ID = "id";
    public static final String GMT_MODIFIED = "gmtModified";
    public static final String GMT_CREATE = "gmtCreate";
    public static final String GMT_MODIFIED_USER = "gmtModifiedUser";
    public static final String FS_MATERIAL_ID = "fsMaterialId";
    public static final String FS_SETTLE_INFO_REQ = "fsSettleInfoReq";
    public static final String FS_CERTIFICATE_REQ = "fsCertificateReq";
    public static final String SUPPLIER_BASE_INFO_ID = "supplierBaseinfoId";
    public static final String FS_CERTIFICATE_IMG_REQ_LIST = "fsCertificateImgReqList";
    public static final String FS_SUPPLIER_DISTRIBUTION_MANAGEMENT_ADD_REQ_LIST = "fsSupplierDistributionManagementAddReqList";
    public static final String JOB = "job";

    public static final String OMS = "oms";
    public static final String CLIENT_KEY = "clientKey";
    public static final String CLIENT_SECRET = "clientSecret";

    public static final int NUM_0 = 0;
    public static final int NUM_1 = 1;
    public static final int NUM_2 = 2;
    public static final int NUM_3 = 3;
    public static final int NUM_4 = 4;
    public static final int NUM_5 = 5;
    public static final int NUM_6 = 6;
    public static final int NUM_10 = 10;
    public static final int NUM_13 = 13;
    public static final int NUM_15 = 15;
    public static final int NUM_50 = 50;
    public static final int NUM_100 = 100;
    public static final int NUM_200 = 200;
    public static final int NUM_500 = 500;
    public static final int NUM_1000 = 1000;
    public static final int NUM_1024 = 1024;
    public static final int NUM_102400 = 102400;
    public static final int NUM_999999 = 999999;
    public static final double NUM_0_0001 = 0.0001;
    public static final double NUM_999999_9999 = 999999.9999;

    /**
     * OSS图片等比缩放、当目标缩放图大于原图时不进行缩放、图片相对质量设置为70%
     */
    public static final String THUMB_STYLE = "image/resize,m_mfit,w_200,h_200,limit_1/quality,q_70";

    /**
     * 是、否
     */
    public static final List<String> YES_NO = Arrays.asList(YES, NO);

    public static final String OPS_QUEUE = "opsQueue";
    public static final String DATA_OPERATOR_LOG_QUEUE = "dataOperatorLogQueue";
    public static final String SERVICE_LOG_QUEUE = "serviceLogQueue";
    public static final String SERVICE_LOG_ERR_QUEUE = "serviceLogErrQueue";
    public static final String ID_QUEUE = "idQueue";
    public static final String REDIS_ID_QUEUE = "redisIdQueue";

    public static final String REDIS_ID_SCRIPT = "redisIdScript";
    public static final String REDIS_ID_SET_SCRIPT = "redisIdSetScript";

    public static final String REDIS_ID_LUA = "local a = redis.call('get', KEYS[1])\n" +
            "if(a<ARGV[1]) then\n" +
            "     redis.call('set', KEYS[1], ARGV[2])\n" +
            "end\n" +
            "redis.call('del', KEYS[2])\n";

    public static final String REDIS_ID_SET_LUA = "local a = redis.call('sismember', KEYS[1], ARGV[1])\n" +
            "if(a~=1) then\n" +
            "     redis.call('sadd', KEYS[1], ARGV[1])\n" +
            "end\n" +
            "return a\n";

    /**
     * 需要校验的供应商证件类型
     */
    public static final List<String> CERTIFICATE_LIST = Arrays.asList("营业执照", "药品经营许可证",
            "医疗器械经营企业许可证", "保健食品经营许可证", "食品经营许可证", "法人授权委托书", "质量保证协议书", "年报");

    /**
     * 物料导出  Excel 表头
     */
    public static final Map<String, String> MATERIAL_HEADER = new LinkedHashMap<>(16);
    /**
     * 采购订单根据条件导出  汇总 Excel 表头
     */
    public static final Map<String, String> ORDER_HEADER = new LinkedHashMap<>(16);
    /**
     * 采购订单根据条件导出  明细 Excel 表头
     */
    public static final Map<String, String> ORDER_DETAIL_HEADER = new LinkedHashMap<>(64);
    /**
     * 采购入库根据条件导出  汇总 Excel 表头
     */
    public static final Map<String, String> WMS_ASN_BACK_REWRITE_HEADER = new LinkedHashMap<>(8);
    /**
     * 采购入库根据条件导出  明细 Excel 表头
     */
    public static final Map<String, String> WMS_ASN_BACK_REWRITE_DETAIL_HEADER = new LinkedHashMap<>(32);

    /**
     * 采购退货根据条件导出  汇总 Excel 表头
     */
    public static final Map<String, String> PURCHASE_RETURN_HEADER = new LinkedHashMap<>(8);
    /**
     * 采购退货根据条件导出  明细 Excel 表头
     */
    public static final Map<String, String> PURCHASE_RETURN_DETAIL_HEADER = new LinkedHashMap<>(32);
    /**
     * 供应商根据条件导出 Excel 表头
     */
    public static final Map<String, String> SUPPLIER_HEADER = new LinkedHashMap<>(32);
    /**
     * 发票根据条件导出 Excel 表头
     */
    public static final Map<String, String> INVOICE_HEAD = new LinkedHashMap<>(11);
    /**
     * 发票明细导出 Excel 表头
     */
    public static final Map<String, String> INVOICE_DETAIL_HEAD = new LinkedHashMap<>(27);

    /**
     * 数据统计根据条件导出 表头
     */
    public static final Map<String, String> STATISTICS_HEADER = new LinkedHashMap<>(16);

    public static final char[] PWD_ARR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();

    public static final String TRACE_ID = "traceId";
    public static final String VOID = "void";

    static {
        MATERIAL_HEADER.put("materialBaseinfoId", "物料编码");
        MATERIAL_HEADER.put("materialBaseinfoName", "物料名称");
        MATERIAL_HEADER.put("isMedicinal", "是否药品");
        MATERIAL_HEADER.put("classificationId", "物料分类ID");
        MATERIAL_HEADER.put("classification", "物料分类");
        MATERIAL_HEADER.put("retailPrice", "零售价");
        MATERIAL_HEADER.put("medicinalCurrencyName", "通用名");
        MATERIAL_HEADER.put("manufacturerName", "生产厂家");
        MATERIAL_HEADER.put("placeoforigin", "产地");
        MATERIAL_HEADER.put("barcode", "商品条码");
        MATERIAL_HEADER.put("qualityClassification", "质管分类");
        MATERIAL_HEADER.put("medicinalEngName", "英文名称");
        MATERIAL_HEADER.put("approvalNumber", "批准文号");
        MATERIAL_HEADER.put("approvalBeginTime", "批准文号起始日期");
        MATERIAL_HEADER.put("approvalEndTime", "批准文号结束日期");
        MATERIAL_HEADER.put("medicinalSubname", "简写");
        MATERIAL_HEADER.put("brand", "品牌");
        MATERIAL_HEADER.put("businessScope", "所属经营范围");
        MATERIAL_HEADER.put("specifications", "规格/型号");
        MATERIAL_HEADER.put("packingSpecification", "包装规格");
        MATERIAL_HEADER.put("caseQty", "标准包装箱数量");
        MATERIAL_HEADER.put("commodityTaxType", "商品税分类");
        MATERIAL_HEADER.put("defaultTax", "默认税率");
        MATERIAL_HEADER.put("inventoryUnit", "库存单位");
        MATERIAL_HEADER.put("isTraditionalChineseMedicine", "是否中药");
        MATERIAL_HEADER.put("isTapparatus", "是否器械");
        MATERIAL_HEADER.put("isRefrigeratedDrugs", "是否冷藏药品");
        MATERIAL_HEADER.put("isEphedrineContaining", "是否含麻黄碱");
        MATERIAL_HEADER.put("isImportedDrugs", "是否进口药品");
        MATERIAL_HEADER.put("isVirtualProduct", "是否虚拟商品");
        MATERIAL_HEADER.put("isCrossBorder", "是否跨境商品");
        MATERIAL_HEADER.put("curingCycle", "养护类型");
        MATERIAL_HEADER.put("isSpecialGoods", "是否特殊商品");
        MATERIAL_HEADER.put("isPoNewProducts", "是否PO新品");
        MATERIAL_HEADER.put("freshIdentification", "生鲜标识");
        MATERIAL_HEADER.put("valuablesIdentification", "贵重品标识");
        MATERIAL_HEADER.put("storageConditionsKey", "存储条件key");
        MATERIAL_HEADER.put("drugSupervisionCodeIdentification", "药监码标识");
        MATERIAL_HEADER.put("isGift", "是否为赠品");
        MATERIAL_HEADER.put("isSerialNumberControlRequired", "是否需要序列号控制");
        MATERIAL_HEADER.put("isShelfLifeControlRequired", "是否需要保质期控制");
        MATERIAL_HEADER.put("quality", "保质期");
        MATERIAL_HEADER.put("qualityUnit", "保质期单位");
        MATERIAL_HEADER.put("batchRuleId", "批次规则ID");
        MATERIAL_HEADER.put("validityOfApproval", "批件有效期");
        MATERIAL_HEADER.put("minimumSafetyStock", "最低安全库存");
        MATERIAL_HEADER.put("maximumSafetyStock", "最高安全库存");
        MATERIAL_HEADER.put("temperatureRange", "温度范围");
        MATERIAL_HEADER.put("humidityRange", "湿度范围");
        MATERIAL_HEADER.put("netWeight", "净重");
        MATERIAL_HEADER.put("netWeightUnit", "净重单位");
        MATERIAL_HEADER.put("roughWeight", "毛重");
        MATERIAL_HEADER.put("roughWeightUnit", "毛重单位");
        MATERIAL_HEADER.put("longer", "长");
        MATERIAL_HEADER.put("longerUnit", "长单位");
        MATERIAL_HEADER.put("widther", "宽");
        MATERIAL_HEADER.put("widtherUnit", "宽单位");
        MATERIAL_HEADER.put("higther", "高");
        MATERIAL_HEADER.put("higtherUnit", "高单位");
        MATERIAL_HEADER.put("volume", "体积");
        MATERIAL_HEADER.put("volumeUnit", "体积单位");
        MATERIAL_HEADER.put("doseUnit", "剂量单位");
        MATERIAL_HEADER.put("dosageForm", "剂型");
        MATERIAL_HEADER.put("category", "药品类别");
        MATERIAL_HEADER.put("effect", "功效分类");
        MATERIAL_HEADER.put("drugProperties", "药品属性");
        MATERIAL_HEADER.put("routeOfAdministration", "用药途径");
        MATERIAL_HEADER.put("frequencyOfUse", "使用频次");
        MATERIAL_HEADER.put("dosage", "用药剂量");
        MATERIAL_HEADER.put("permitHolder", "上市许可持有人");

        ORDER_HEADER.put("purchaseOrder", "采购订单号");
        ORDER_HEADER.put("purchasePlanNo", "采购计划单号");
        ORDER_HEADER.put("storehouseName", "采入仓库");
        ORDER_HEADER.put("supplierName", "供应商");
        ORDER_HEADER.put("cargoownerName", "货主");
        ORDER_HEADER.put("buyer", "采购员");
        ORDER_HEADER.put("platform", "平台/渠道");
        ORDER_HEADER.put("sumAmount", "采购总金额");
        ORDER_HEADER.put("status", "状态");


        ORDER_DETAIL_HEADER.put("purchaseOrder", "采购订单号");
        ORDER_DETAIL_HEADER.put("purchasePlanNo", "采购计划单号");
        ORDER_DETAIL_HEADER.put("storehouseName", "采入仓库");
        ORDER_DETAIL_HEADER.put("supplierName", "供应商");
        ORDER_DETAIL_HEADER.put("cargoownerName", "货主");
        ORDER_DETAIL_HEADER.put("buyer", "采购员");
        ORDER_DETAIL_HEADER.put("platform", "平台/渠道");
        ORDER_DETAIL_HEADER.put("sumAmount", "采购总金额");
        ORDER_DETAIL_HEADER.put("status", "状态");

        ORDER_DETAIL_HEADER.put("contactName", "收货人");
        ORDER_DETAIL_HEADER.put("contactNumber", "收货人电话");
        ORDER_DETAIL_HEADER.put("fullNameAndAddresss", "收货人地址");

        ORDER_DETAIL_HEADER.put("logisticsCompany", "物流公司");
        ORDER_DETAIL_HEADER.put("trackingNumber", "快递单号");
        ORDER_DETAIL_HEADER.put("deliveryTime", "发货时间");
        ORDER_DETAIL_HEADER.put("estimatedArrivalTime", "预计到货时间");
        ORDER_DETAIL_HEADER.put("invoiceIncluded", "是否含发票");
        ORDER_DETAIL_HEADER.put("materialBaseinfoName", "物料名称");
        ORDER_DETAIL_HEADER.put("materialBaseinfoId", "物料编码");
        ORDER_DETAIL_HEADER.put("medicinalSubname", "简写");
        ORDER_DETAIL_HEADER.put("specifications", "规格/型号");
        ORDER_DETAIL_HEADER.put("packingSpecification", "包装规格");
        ORDER_DETAIL_HEADER.put("dosageForm", "剂型");
        ORDER_DETAIL_HEADER.put("purchasePrice", "采购价");
        ORDER_DETAIL_HEADER.put("purchaseNum", "采购数量");
        ORDER_DETAIL_HEADER.put("shipmentQuantity", "发货数量");
        ORDER_DETAIL_HEADER.put("receiptQuantity", "入库数量");
        ORDER_DETAIL_HEADER.put("quantityRejected", "拒收数量");
        ORDER_DETAIL_HEADER.put("reasonForRejection", "拒收原因");
        ORDER_DETAIL_HEADER.put("inventoryUnit", "库存单位");
        ORDER_DETAIL_HEADER.put("manufacturer", "生产厂家");
        ORDER_DETAIL_HEADER.put("barcode", "商品条码");
        ORDER_DETAIL_HEADER.put("remark", "备注");


        WMS_ASN_BACK_REWRITE_HEADER.put("purchaseOrderId", "采购单号");
        WMS_ASN_BACK_REWRITE_HEADER.put("storehouse", "采入仓库");
        WMS_ASN_BACK_REWRITE_HEADER.put("supplierName", "供应商");
        WMS_ASN_BACK_REWRITE_HEADER.put("recheckTime", "入库时间");
        WMS_ASN_BACK_REWRITE_HEADER.put("platform", "平台/渠道");
        WMS_ASN_BACK_REWRITE_HEADER.put("sum", "入库总数");
        WMS_ASN_BACK_REWRITE_HEADER.put("status", "状态");
        WMS_ASN_BACK_REWRITE_HEADER.put("writeOffStatus", "发票核销状态");

        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("purchaseOrderId", "采购单号");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("storehouse", "采入仓库");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("supplierName", "供应商");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("recheckTime", "入库时间");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("platform", "平台/渠道");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("sum", "入库总数");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("qtyQuality", "入库好品数");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("qtyDamage", "入库坏品数");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("status", "状态");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("writeOffStatus", "发票核销状态");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("erpDetailId", "入库明细ID");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("materialBaseinfoId", "物料编码");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("materialBaseinfoName", "物料名称");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("transactionQty", "入库数量");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("arrivalsQty", "到货总数量");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("qualifiedQty", "验证合格总数量");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("purchasePrice", "采购价");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("medicinalSubname", "简写");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("specifications", "规格/型号");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("packingSpecification", "包装规格");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("dosageForm", "剂型");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("lotNo", "生产批次");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("productionTime", "生产日期");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("expiredTime", "有效期");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("batchNo", "WMS批次号");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("isDamaged", "是否坏品");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("processingMethod", "处理方式");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("recheckBy", "验收人员");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("warehouseTime", "入库日期");
        WMS_ASN_BACK_REWRITE_DETAIL_HEADER.put("finishReceiptTime", "到货日期");

        PURCHASE_RETURN_HEADER.put("purchaseReturnId", "采购退货单号");
        PURCHASE_RETURN_HEADER.put("purchaseId", "采购订单号");
        PURCHASE_RETURN_HEADER.put("warehouseName", "采入仓库");
        PURCHASE_RETURN_HEADER.put("supplierName", "供应商");
        PURCHASE_RETURN_HEADER.put("cargoOwnerName", "货主");
        PURCHASE_RETURN_HEADER.put("platform", "平台/渠道");
        PURCHASE_RETURN_HEADER.put("status", "状态");
        PURCHASE_RETURN_HEADER.put("writeOffStatus", "发票核销状态");

        PURCHASE_RETURN_DETAIL_HEADER.put("purchaseReturnId", "采购退货单号");
        PURCHASE_RETURN_DETAIL_HEADER.put("purchaseId", "采购订单号");
        PURCHASE_RETURN_DETAIL_HEADER.put("warehouseName", "采入仓库");
        PURCHASE_RETURN_DETAIL_HEADER.put("supplierName", "供应商");
        PURCHASE_RETURN_DETAIL_HEADER.put("cargoOwnerName", "货主");
        PURCHASE_RETURN_DETAIL_HEADER.put("platform", "平台/渠道");
        PURCHASE_RETURN_DETAIL_HEADER.put("buyerName", "采购员");
        PURCHASE_RETURN_DETAIL_HEADER.put("status", "状态");
        PURCHASE_RETURN_DETAIL_HEADER.put("writeOffStatus", "发票核销状态");
        PURCHASE_RETURN_DETAIL_HEADER.put("contactName", "收货人");
        PURCHASE_RETURN_DETAIL_HEADER.put("contactNumber", "收货人电话");
        PURCHASE_RETURN_DETAIL_HEADER.put("storehouseAddress", "收货地址");
        PURCHASE_RETURN_DETAIL_HEADER.put("putInStorageId", "入库明细ID");
        PURCHASE_RETURN_DETAIL_HEADER.put("materialBaseinfoId", "物料编码");
        PURCHASE_RETURN_DETAIL_HEADER.put("materialBaseinfoName", "物料名称");
        PURCHASE_RETURN_DETAIL_HEADER.put("putInNum", "入库数量");
        PURCHASE_RETURN_DETAIL_HEADER.put("purchaseReturnNum", "退货数量");
        PURCHASE_RETURN_DETAIL_HEADER.put("transactionQty", "出库数量");
        PURCHASE_RETURN_DETAIL_HEADER.put("purchasePrice", "采购价（￥）");
        PURCHASE_RETURN_DETAIL_HEADER.put("medicinalSubname", "简写");
        PURCHASE_RETURN_DETAIL_HEADER.put("specifications", "规格/型号");
        PURCHASE_RETURN_DETAIL_HEADER.put("packingSpecification", "包装规格");
        PURCHASE_RETURN_DETAIL_HEADER.put("lotno", "生产批次");
        PURCHASE_RETURN_DETAIL_HEADER.put("productionTime", "生产日期");
        PURCHASE_RETURN_DETAIL_HEADER.put("expiredTime", "有效期");
        PURCHASE_RETURN_DETAIL_HEADER.put("wmsBatchNo", "WMS批次号");
        PURCHASE_RETURN_DETAIL_HEADER.put("isDamaged", "是否坏品");
        PURCHASE_RETURN_DETAIL_HEADER.put("receiveDate", "入库日期");

        SUPPLIER_HEADER.put("supplierBaseinfoId", "供应商编码");
        SUPPLIER_HEADER.put("supplierName", "供应商名称");
        SUPPLIER_HEADER.put("supplierSubname", "简写");
        SUPPLIER_HEADER.put("contactName", "联系人");
        SUPPLIER_HEADER.put("contactNumber", "联系人手机号");
        SUPPLIER_HEADER.put("supplierType", "供应商类型");
        SUPPLIER_HEADER.put("status", "状态");
        SUPPLIER_HEADER.put("contactAddress", "注册地址");
        SUPPLIER_HEADER.put("postalCode", "邮政");
        SUPPLIER_HEADER.put("businessArea", "营业面积");
        SUPPLIER_HEADER.put("legalPerson", "公司法人");
        SUPPLIER_HEADER.put("taxNum", "税号");
        SUPPLIER_HEADER.put("deliveryDay", "最晚送货天数");
        SUPPLIER_HEADER.put("isSiteAcceptance", "是否现场验收");
        SUPPLIER_HEADER.put("remarks", "简介/备注");
        SUPPLIER_HEADER.put("businessInformation", "经营信息");
        SUPPLIER_HEADER.put("wareHouseContactName", "仓库联系人");
        SUPPLIER_HEADER.put("wareHouseContactNumber", "仓库联系人电话");
        SUPPLIER_HEADER.put("wareHouseAddress", "仓库地址");
        SUPPLIER_HEADER.put("rejectContactName", "退货联系人");
        SUPPLIER_HEADER.put("rejectContactNumber", "退货联系人电话");
        SUPPLIER_HEADER.put("rejectAddress", "退货地址");
        SUPPLIER_HEADER.put("accountName", "开户户名");
        SUPPLIER_HEADER.put("bank", "开户银行");
        SUPPLIER_HEADER.put("account", "银行账号");
        SUPPLIER_HEADER.put("fullName", "开票公司地址");

        INVOICE_HEAD.put("billNo", "单据编号");
        INVOICE_HEAD.put("invoiceNo", "发票号码");
        INVOICE_HEAD.put("supplier", "供应商ID");
        INVOICE_HEAD.put("supplierName", "供应商名称");
        INVOICE_HEAD.put("payAmount", "应付金额（￥）");
        INVOICE_HEAD.put("tax", "税额（￥）");
        INVOICE_HEAD.put("excludingTaxAmount", "不含税金额（￥）");
        INVOICE_HEAD.put("invoiceType", "发票类型");
        INVOICE_HEAD.put("gmtModifiedUser", "更新人");
        INVOICE_HEAD.put("gmtModified", "更新时间");
        INVOICE_HEAD.put("gmtCreate", "创建时间");

        INVOICE_DETAIL_HEAD.put("billNo", "单据编号");
        INVOICE_DETAIL_HEAD.put("invoiceNo", "发票号码");
        INVOICE_DETAIL_HEAD.put("supplierId", "供应商ID");
        INVOICE_DETAIL_HEAD.put("supplierName", "供应商名称");
        INVOICE_DETAIL_HEAD.put("payAmount", "应付总金额（￥）");
        INVOICE_DETAIL_HEAD.put("totalTax", "总税额（￥）");
        INVOICE_DETAIL_HEAD.put("excludingTaxAmount", "不含税总金额（￥）");
        INVOICE_DETAIL_HEAD.put("invoiceType", "发票类型");
        INVOICE_DETAIL_HEAD.put("returnReturnId", "采购退货单号");
        INVOICE_DETAIL_HEAD.put("purchaseId", "采购订单号");
        INVOICE_DETAIL_HEAD.put("trsId", "入库明细ID");
        INVOICE_DETAIL_HEAD.put("materialBaseinfoId", "物料编码");
        INVOICE_DETAIL_HEAD.put("materialBaseinfoName", "物料名称");
        INVOICE_DETAIL_HEAD.put("specifications", "规格/型号");
        INVOICE_DETAIL_HEAD.put("packingSpecification", "包装规格");
        INVOICE_DETAIL_HEAD.put("inventoryUnit", "单位");
        INVOICE_DETAIL_HEAD.put("transactionQty", "入库数量");
        INVOICE_DETAIL_HEAD.put("outTransactionQty", "出库数量");
        INVOICE_DETAIL_HEAD.put("purchasePrice", "采购价（￥）");
        INVOICE_DETAIL_HEAD.put("storehouseName", "采入仓库");
        INVOICE_DETAIL_HEAD.put("warehouseTime", "入库日期");
        INVOICE_DETAIL_HEAD.put("platform", "平台/渠道");
        INVOICE_DETAIL_HEAD.put("amount", "不含税金额（￥）");
        INVOICE_DETAIL_HEAD.put("taxRate", "税率（%）");
        INVOICE_DETAIL_HEAD.put("tax", "税额");
        INVOICE_DETAIL_HEAD.put("discounted", "是否折让");
        INVOICE_DETAIL_HEAD.put("discountedAmountExceptTax", "折让不含税金额");
        INVOICE_DETAIL_HEAD.put("discountedTaxAmount", "折让税额");
        INVOICE_DETAIL_HEAD.put("gmtModifiedUser", "更新人");
        INVOICE_DETAIL_HEAD.put("gmtModified", "更新时间");
        INVOICE_DETAIL_HEAD.put("gmtCreate", "创建时间");

        STATISTICS_HEADER.put("supplier", "供应商编码");
        STATISTICS_HEADER.put("supplierName", "供应商名称");
        STATISTICS_HEADER.put("materialBaseinfoId", "物料编码");
        STATISTICS_HEADER.put("materialBaseinfoName", "物料名称");
        STATISTICS_HEADER.put("receivableAmount", "应收金额");
        STATISTICS_HEADER.put("purchaseAmount", "采购金额");
        STATISTICS_HEADER.put("purchaseQty", "采购数量");
        STATISTICS_HEADER.put("contractNo", "合同编码");
        STATISTICS_HEADER.put("contractName", "合同名称");
        STATISTICS_HEADER.put("ruleNo", "返利规则编码");
        STATISTICS_HEADER.put("specifications", "规格/型号");
        STATISTICS_HEADER.put("packingSpecification", "包装规格");
        STATISTICS_HEADER.put("barcode", "商品条码");
        STATISTICS_HEADER.put("approvalNumber", "批准文号");
    }
}
