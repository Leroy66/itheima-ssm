package com.itheima.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.ssm.mapper.CustomerDao;
import com.itheima.ssm.pojo.BaseDictPojo;
import com.itheima.ssm.pojo.CustomerListRequestParam;
import com.itheima.ssm.pojo.CustomerPojo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;

	@Override
	public Page<CustomerPojo> selectCustomerListByCondition(CustomerListRequestParam param) {
		Page<CustomerPojo> result = new Page<CustomerPojo>();
		result.setSize(param.getPageSize());
		result.setPage(param.getPageNum());

		Integer total = customerDao.countCustomerListByCondition(param);
		List<CustomerPojo> rows = customerDao.selectCustomerListByCondition(param);
		result.setTotal(total);
		result.setRows(rows);
		return result;
	}

}
