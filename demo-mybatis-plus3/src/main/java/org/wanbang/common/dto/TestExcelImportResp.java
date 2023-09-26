package org.wanbang.common.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 物料信息表(FsMaterial)实体类
 *
 * @author makejava
 * @since 2021-07-07 15:34:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestExcelImportResp implements Serializable {
    private static final long serialVersionUID = 734660291847662940L;

    /**
     * 课程名称
     */
    @Excel(name = "名称")
    private String mjjName;

    /**
     * 金额
     */
    @Excel(name = "图片")
    private String picture;


}
