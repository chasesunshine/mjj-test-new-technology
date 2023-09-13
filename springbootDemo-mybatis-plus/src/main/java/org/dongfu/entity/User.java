package org.dongfu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.dongfu.entity.common.BaseParam;

import java.time.LocalDateTime;

@Data
@Accessors(chain=true)	//链式设置属性
@TableName(value="user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseParam {
	
	@TableId(type=IdType.AUTO)		//表示主键自增
	private Integer id;

	private String name;
	private Integer age;
	private String sex;

	@TableField("begin_time")
	private LocalDateTime beginTime;

	@TableField("end_time")
	private LocalDateTime endTime;

	@TableField("gmt_create")
	private LocalDateTime gmtCreate;
}
