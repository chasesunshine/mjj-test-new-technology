package org.wanbang.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "性别",index = 1)
    private String sex;

    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;

    @ExcelProperty(value = "身份证",index = 3)
    private String cardId;
}
