package org.dongfu.config.properties;

import lombok.Data;

/**
 * @author lijun
 */
@Data
public class TemplateProperties {

    /**
     * 批量导入物料模板
     */
    private String materialExcel;

    /**
     * 采购明细_批量导入物料
     */
    private String purchaseDetailExcel;

    /**
     * 采购订单批量导入发货模板
     */
    private String purchaseOrderDeliverGoodsExcel;

}
