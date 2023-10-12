package org.wanbang;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatisPlusPage {
    @Resource
    private UserDao userDao;

    /**
     * MyBatis-Plus分页插件
     * https://blog.csdn.net/qq_43297569/article/details/130521659
     *
     */
    @Test
    public void contextLoads() {
        Page<User> page=new Page<>(0,5);
        Page<User> stuPage = userDao.selectPage(page, new QueryWrapper<User>().lambda().eq(User::getName,"11"));
        stuPage.getRecords().forEach(System.out::println);
        System.out.println("当前页:"+stuPage.getCurrent());
        System.out.println("总页数:"+stuPage.getPages());
        System.out.println("总数据条数:"+stuPage.getTotal());
        System.out.println("是否有上一页："+stuPage.hasPrevious());
        System.out.println("是否有下一页："+stuPage.hasNext());

    }
}
