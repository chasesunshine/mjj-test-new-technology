package org.wanbang.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.config.BeanConfig;
import org.wanbang.entity.User;
import org.wanbang.mapper.UserMapper;
import org.wanbang.service.MyService;
import org.wanbang.util.thread.MyThread;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestThrrad {
	
	@Resource
	private UserMapper userMapper;

	// http://www.manongjc.com/article/9120.html
	/**
	 *    测试类
	 */
	@Test
	public void test1(){
			MyService service = new MyService();
			//实例化 并且实例化的时候默认就调用start()方法启动
			MyThread thread1 = new MyThread(service);
			MyThread thread2 = new MyThread(service);
			MyThread thread3 = new MyThread(service);
			MyThread thread4 = new MyThread(service);
	}

	
	
	
}
