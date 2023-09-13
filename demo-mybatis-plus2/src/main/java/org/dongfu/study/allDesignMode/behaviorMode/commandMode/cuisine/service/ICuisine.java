package org.dongfu.study.allDesignMode.behaviorMode.commandMode.cuisine.service;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:21
* @version 1.0
*/

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！
 * 公众号：bugstack⾍洞栈
 * Create by ⼩傅哥(fustack) @2020
 *
 * 菜系
 * 01、⼭东（鲁菜）——宫廷最⼤菜系，以孔府⻛味为⻰头。
 * 02、四川（川菜）——中国最有特⾊的菜系，也是⺠间最⼤菜系。
 * 03、江苏（苏菜）——宫廷第⼆⼤菜系，古今国宴上最受⼈欢迎的菜系。
 * 04、⼴东（粤菜）——国内⺠间第⼆⼤菜系，国外最有影响⼒的中国菜系，可以代表中国。
 * 05、福建（闽菜）——客家菜的代表菜系。
 * 06、浙江（浙菜）——中国最古⽼的菜系之⼀，宫廷第三⼤菜系。
 * 07、湖南（湘菜）——⺠间第三⼤菜系。
 * 08、安徽（徽菜）——徽州⽂化的典型代表。
 */

/**
 * 这是命令接⼝类的定义，并提供了⼀个烹饪⽅法。后⾯会选四种菜品进⾏实现
 */
public interface ICuisine {

    void cook(); // 烹调、制作

}
