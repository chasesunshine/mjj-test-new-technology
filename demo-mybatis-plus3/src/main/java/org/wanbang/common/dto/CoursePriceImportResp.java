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
public class CoursePriceImportResp implements Serializable {
    private static final long serialVersionUID = 734660291847662940L;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String courseName;

    /**
     * 金额
     */
    @Excel(name = "金额（单位：元）")
    private String price;

    /**
     * 课程id
     */
    @Excel(name = "中M-ID")
    private String courseId;


//    /**
//     * 批准文号起始日期
//     */
//    @Excel(name = "批准文号起始日期", isImportField = "true", exportFormat = "yyyy/MM/dd", importFormat = "yyyy/MM/dd")
//    private String approvalBeginTime;

}
