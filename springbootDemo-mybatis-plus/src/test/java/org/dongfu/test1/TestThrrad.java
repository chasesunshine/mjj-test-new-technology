package org.dongfu.test1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.dongfu.mapper.UserMapper;
import org.dongfu.service.MyService;
import org.dongfu.util.thread.MyThread;

import javax.annotation.Resource;

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
