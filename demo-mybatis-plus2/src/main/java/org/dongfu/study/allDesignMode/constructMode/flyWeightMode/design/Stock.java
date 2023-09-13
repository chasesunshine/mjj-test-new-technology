package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.design;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/17 17:54
* @version 1.0
*/

@Data
@AllArgsConstructor
public class Stock {
    private int total; // 库存总量
    private int used; // 库存已⽤

    // ...get/set
}
