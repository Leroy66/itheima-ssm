package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.BaseDictPojo;

public interface BaseDictDao {

	// 根据类别代码查询数据
	public List<BaseDictPojo> selectBaseDictListByCode(String code);

}
