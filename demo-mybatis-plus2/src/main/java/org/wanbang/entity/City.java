package org.wanbang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)	//链式设置属性
@TableName(value="city")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
	
	@TableId(type=IdType.AUTO)		//表示主键自增
	@TableField(value = "ID")
	private Integer id;

	@TableField(value = "Name")
	private String name;

	@TableField(value = "CountryCode")
	private String countryCode;

	@TableField(value = "District")
	private String district;

	@TableField(value = "Population")
	private Integer population;
}
