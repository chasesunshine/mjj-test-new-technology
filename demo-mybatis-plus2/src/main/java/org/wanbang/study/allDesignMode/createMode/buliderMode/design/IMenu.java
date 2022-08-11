package org.wanbang.study.allDesignMode.createMode.buliderMode.design;

import org.wanbang.study.allDesignMode.createMode.buliderMode.service.Matter;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 13:34
* @version 1.0
*/

public interface IMenu {
    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter); // 涂料

    IMenu appendFloor(Matter matter); // 地板

    IMenu appendTile(Matter matter); // 地砖

    String getDetail(); // 明细
}
