package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.BaseDictPojo;
import com.itheima.ssm.pojo.CustomerListRequestParam;
import com.itheima.ssm.pojo.CustomerPojo;

public interface CustomerDao {

	public Integer countCustomerListByCondition(CustomerListRequestParam param);

	public List<CustomerPojo> selectCustomerListByCondition(CustomerListRequestParam param);

	public CustomerPojo selectCustomerById(Integer id);

	public void updateCustomerById(CustomerPojo customer);

	public void deleteCustomerById(Integer id);

}
