package org.wanbang.test;

import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.wanbang.mapper.UserMapper;
import org.wanbang.entity.User;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatis {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testFindUser() {
		
		//List<User> userList = userMapper.findAll();
		//System.out.println(userList);
	}
	
	//新增用户信息
	@Test
	public void testSaveUser(){
		User user = new User();
		/*user.setName("诺克赛斯之手");
		user.setAge(100);
		user.setSex("男");*/
		user.setName("诺克赛斯之手").setAge(100).setSex("男");
		userMapper.insert(user);
		System.out.println("入库成功");
	}
	
	//删除用户信息
	@Test
	public void testDeleteUser(){
		//userMapper.deleteById(67);  删除主键信息
		
		//删除为null的数据
		//先查询再删除
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.isNull("name");	//删除指定数据
		userMapper.delete(queryWrapper);
		System.out.println("删除成功!!!");
	}
	
	//修改用户信息
	@Test
	public void testUpdateUser() {
		//entity用户set数据.updateWrapper用户设定where条件
		User user = new User();
		user.setName("复仇炎魂");
		user.setAge(2000);
		user.setSex("男");
		
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("id", 68);
		userMapper.update(user,updateWrapper);
		System.out.println("修改数据完成");
		
	}
	
	//查询用户信息
	@Test
	public void testQueryUser() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("age", 2000);  	//查询年龄为200岁的
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}





	@Test
	public void testQueryUser1() {
//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("age", 2000);  	//查询年龄为200岁的
		User userList = userMapper.selectOne(Wrappers.<User>query().lambda()
				.eq(User::getId,1)
		.last("limit 1"));

		System.out.println(userList);
	}
	
	
	
	
	
	
}
