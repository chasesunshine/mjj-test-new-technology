package org.wanbang.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sun.xml.internal.ws.util.UtilException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.wanbang.mapper.CityMapper;
import org.wanbang.entity.City;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatis {

	@Resource
	private CityMapper cityMapper;

	private static final Charset ENCODER = StandardCharsets.UTF_8;
	private static final MessageDigest MESSAGE;
	private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	private static final int NUM_16 = 16;

	static {
		try {
			MESSAGE = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new UtilException("获取MD5 对象失败", e);
		}
	}

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
		String str = "mjj12321321";
		try {
			MESSAGE.update(str.getBytes(ENCODER));
			byte[] b = MESSAGE.digest();

			StringBuilder digestHexStr = new StringBuilder();
			for (int i = 0; i < NUM_16; i++) {
				digestHexStr.append(byte2HexStr(b[i]));
			}
			String s = digestHexStr.toString();
			System.out.println("数据 ："+ s);
		} catch (Exception e) {
			throw new UtilException("Md5加密失败", e);
		}
	}

	/**
	 * 转化成16 进制
	 *
	 * @param ib byte
	 * @return java.lang.String
	 */
	private static String byte2HexStr(byte ib) {
		char[] ob = new char[2];
		ob[0] = HEX_DIGITS[(ib >>> 4 & 0xF)];
		ob[1] = HEX_DIGITS[(ib & 0xF)];
		return new String(ob);
	}

	/**
	 * 转化成16 进制
	 *
	 * @param ib byte
	 * @return java.lang.String
	 */
	@Test
	public void byte2HexStr2() {
		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		System.out.println("Original...");
		System.out.println(unsortMap);

		// sort by values, and reserve it, 10,9,8,7,6...
		Map<String, Integer> result = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));

		// Alternative way
		Map<String, Integer> result2 = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		System.out.println("Sorted...");
		System.out.println(result);
		System.out.println(result2);
	}

}
