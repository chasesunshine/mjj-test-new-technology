package org.wanbang.test;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.wanbang.mapper.CityMapper;
import org.wanbang.pojo.City;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatis {

	@Autowired
	private CityMapper cityMapper;


	@Test
	public void testQueryUser1() {
		City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
				.eq(City::getId,1).last("limit 1"));

		System.out.println(city);
	}






}
