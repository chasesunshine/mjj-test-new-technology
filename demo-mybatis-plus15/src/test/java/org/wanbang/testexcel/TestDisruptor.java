package org.wanbang.testexcel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.excel.User;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestDisruptor {

	@Test
	public void testExcelImport(){
		// 生成Excel路径
		String fileName = "C:\\Users\\daikin\\Desktop\\测试.xlsx";
		List<User> data = data();
		EasyExcel.write(fileName, User.class).sheet("模板").doWrite(data);
	}

	private List<User> data() {
		List<User> userList = new ArrayList<>();
		User user;
		for (int i = 1; i <= 10; i++) {
			user = new User();
			user.setName("张三" + i);
			user.setSex("男");
			user.setAge(i);
			user.setCardId("440582xxxx");
			userList.add(user);
		}
		return userList;
	}

	@Test
	public void testExcelExport(){
		// 生成Excel路径
		String fileName = "C:\\Users\\daikin\\Desktop\\测试.xlsx";
		List<User> dataList = EasyExcel.read(fileName)
				.head(User.class)
				.sheet()
				.doReadSync();
		System.out.println(JSON.toJSONString(dataList));
	}

}
