package org.wanbang.common.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
* @description: TODO
* @author majiajian
* @date 2022/6/22 17:44
* @version 1.0
*/

@ExcelTarget("goodsEntity")
@Data
@Component
public class GoodsHasImgModel {

    @Excel(name = "名称")
    private String goodsName;

    //savePath配置的是解析excel后存放图片的路径
    @Excel(name = "照片", type = 2, width = 20, height = 10, imageType = 1, savePath = "C:\\Users\\majiajian\\Desktop\\东方福利网\\供应链全部")
    private String goodsPic;

}
