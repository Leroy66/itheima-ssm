package com.itheima.ssm.service;

import com.itheima.common.utils.Page;
import com.itheima.ssm.pojo.CustomerListRequestParam;
import com.itheima.ssm.pojo.CustomerPojo;

public interface CustomerService {

	/**
	 * 根据条件查询客户列表
	 * 
	 * @param param
	 * @return
	 */
	public Page<CustomerPojo> selectCustomerListByCondition(CustomerListRequestParam param);

}
