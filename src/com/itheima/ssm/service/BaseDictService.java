package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.BaseDictPojo;

public interface BaseDictService {

	/**
	 * 根据类别代码查询数据
	 * 
	 * @param code
	 * @return
	 */
	public List<BaseDictPojo> selectBaseDictListByCode(String code);

}
