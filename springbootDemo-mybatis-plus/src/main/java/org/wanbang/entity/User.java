package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)	//链式设置属性
@TableName(value="user")
public class User {
	
	@TableId(type=IdType.AUTO)		//表示主键自增
	private Integer id;

	private String name;
	private Integer age;
	private String sex;

}
