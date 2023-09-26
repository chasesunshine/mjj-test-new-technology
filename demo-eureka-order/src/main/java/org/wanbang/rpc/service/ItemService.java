package org.wanbang.rpc.service;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:55
* @version 1.0
*/

import org.wanbang.feign.ItemFeignClient;
import org.wanbang.rpc.entity.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemService {

    @Resource
    private ItemFeignClient itemFeignClient;


    /**
     * 通过注册中心，并且使用feign来做RPC调用
     * */
    public Item queryItemById(Long id) {
        Item result = itemFeignClient.queryItemById(id);
        return result;
    }

}