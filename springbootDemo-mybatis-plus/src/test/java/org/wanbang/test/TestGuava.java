package org.wanbang.test;

import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestGuava {
	
	@Test
	public void test(){
		System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));//testData
	}


	@Test
	public void test1(){
		String s = "1|";
		String s1 = "12068|12070|";
		String s2 = "1|118|11801|";

		String[] split = s.split("\\|");
		String[] split1 = s1.split("\\|");
		String[] split2 = s2.split("\\|");

		System.out.println(split[split.length-1]);
		System.out.println(split1[split1.length-1]);
		System.out.println(split2[split2.length-1]);
	}

}
