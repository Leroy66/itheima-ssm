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

	/**
	 * 查看客户详细信息
	 * 
	 * @param id
	 * @return
	 */
	public CustomerPojo selectCustomerById(Integer id);

	/**
	 * 修改客户信息
	 * 
	 * @param customer
	 */
	public void updateCustomerById(CustomerPojo customer);

	/**
	 * 删除客户
	 * @param customer
	 */
	public void deleteCustomerById(Integer id);

}
