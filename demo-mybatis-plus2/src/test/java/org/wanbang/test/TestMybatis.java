package org.wanbang.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.wanbang.mapper.CityMapper;
import org.wanbang.entity.City;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatis {

	@Resource
	private CityMapper cityMapper;

	@Test
	public void testQueryUser1() {
		City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
				.eq(City::getId,1).last("limit 1"));

		System.out.println(city);
	}

	@Test
	public void testQueryUser2() {
		City build = City.builder().id(1).countryCode("2").build();
		City build1 = City.builder().id(2).countryCode("3").build();
		System.out.println(build);
		System.out.println(build1);
	}
	@Test
	public void testQueryUser3() {
		Map<Integer , City> cityMap= new HashMap<>();
		City build = City.builder().id(1).countryCode("2").build();
		City build1 = City.builder().id(2).countryCode("3").build();
		cityMap.put(build.getId(),build);
		cityMap.put(build1.getId(),build1);

		System.out.println(cityMap.get(1));

		City city = cityMap.get(1);
		city.setCountryCode("4");
		//cityMap.put(build.getId(),build.setCountryCode("4"));
		System.out.println(cityMap.get(1));
	}


	@Test
	public void testQueryUser4() {
		ArrayList<Object> objects = new ArrayList<>();
		objects.stream().forEach(o -> {

		});
	}

	@Test
	public void testQueryUser5() {
		String value = "、1、2、3";
		String substring = value.substring(1);
		System.out.println(substring);
	}

	@Test
	public void testQueryUser6() throws InterruptedException {
		Date date = new Date();
		long time = date.getTime();

		for (int i = 0; i < 2; i++) {
			int a = i;
			Thread.sleep(1000);
		}

		Date date2 = new Date();
		long time1 = date2.getTime();

		System.out.println(time1 - time);
	}


	@Test
	public void test11111() throws IllegalAccessException {
		City build = City.builder().id(1).countryCode("2").name("3").build();
		Object obj = build;
		System.out.println(build);
		System.out.println(obj);

		Field[] declaredFields = build.getClass().getDeclaredFields();
		String urlAdd = "";
		for (Field f:declaredFields) {
			f.setAccessible(true);
			String name = f.getName();
			Object value = f.get(obj);
			if(ObjectUtils.isEmpty(value)){
				continue;
			}
			urlAdd = urlAdd + name+"="+value.toString()+"&";
		}
		System.out.println(urlAdd.substring(0,urlAdd.length()-1));

	}



	@Test
	public void testQueryUser8() {
		String value = "、1、2、3";
		String substring = value.substring(1);
		System.out.println(substring);
	}
}
