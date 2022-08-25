package org.wanbang.study.allDesignMode.behaviorMode.templateMode.common;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:17
* @version 1.0
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 基础电商推⼴服务
 * 1. ⽣成最优价商品海报
 * 2. 海报含带推⼴邀请码
 */
public abstract class NetMall {
    protected Logger logger = LoggerFactory.getLogger(NetMall.class);
    String uId; // ⽤户ID
    String uPwd; // ⽤户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }
    /**
     * ⽣成商品推⼴海报
     *
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海报图⽚base64位信息
     */
    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null; // 1. 验证登录
        Map<String, String> reptile = reptile(skuUrl); // 2. 爬⾍商品
        return createBase64(reptile); // 3. 组装海报
    }
    // 模拟登录
    protected abstract Boolean login(String uId, String uPwd);
    // 爬⾍提取商品信息(登录后的优惠价格)
    protected abstract Map<String, String> reptile(String skuUrl);
    // ⽣成商品海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);
}
