package org.dongfu.study.anno;

/**
 * Created by yz on 2018/6/3.
 */
@ExtService
public class UserServiceImpl implements UserService {

    @ExtResource
    private OrderService orderService;

    @Override
    public void add(){
        orderService.addOrder();
    }

}