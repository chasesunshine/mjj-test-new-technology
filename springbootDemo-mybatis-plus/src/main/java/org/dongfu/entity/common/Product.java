package org.dongfu.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain=true)	//链式设置属性
@AllArgsConstructor
public class Product {
    private Long id;
    private Integer num;
    private BigDecimal price;
    private String nam;
    private String category;
}
