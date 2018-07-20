package com.itheima.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.ssm.pojo.BaseDictPojo;
import com.itheima.ssm.pojo.CustomerListRequestParam;
import com.itheima.ssm.pojo.CustomerPojo;
import com.itheima.ssm.service.BaseDictService;
import com.itheima.ssm.service.CustomerService;

@Controller
public class CustomerController {

	@Resource
	private BaseDictService baseDictService;
	@Resource
	private CustomerService customerService;

	// 客户来源
	@Value("${BASE_DICT_RFOM_TYPR}")
	private String BASE_DICT_RFOM_TYPR;
	// 所属行业
	@Value("${BASE_DICT_INDUSTRY_TYPE}")
	private String BASE_DICT_INDUSTRY_TYPE;
	// 客户等级
	@Value("${BASE_DICT_LEVEL_TYPE}")
	private String BASE_DICT_LEVEL_TYPE;

	@RequestMapping(value = "/customer/list")
	public String list(CustomerListRequestParam requestParam, Model model) {
		// 处理初始值
		requestParam.setStartIndex((requestParam.getPageNum() - 1) * requestParam.getPageSize());

		// 头部的筛选条件
		List<BaseDictPojo> fromType = baseDictService.selectBaseDictListByCode(BASE_DICT_RFOM_TYPR);
		List<BaseDictPojo> industryType = baseDictService.selectBaseDictListByCode(BASE_DICT_INDUSTRY_TYPE);
		List<BaseDictPojo> levelType = baseDictService.selectBaseDictListByCode(BASE_DICT_LEVEL_TYPE);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		Page<CustomerPojo> pageList = customerService.selectCustomerListByCondition(requestParam);
		model.addAttribute("page", pageList);

		// 回显头部的搜索条件
		model.addAttribute("custName", requestParam.getCustName());
		model.addAttribute("custSource", requestParam.getCustSource());
		model.addAttribute("custIndustry", requestParam.getCustIndustry());
		model.addAttribute("custLevel", requestParam.getCustLevel());
		return "customer";
	}

	// 查找客户详细信息
	@RequestMapping(value = "customer/edit.action")
	public @ResponseBody CustomerPojo editCustomer(Integer id) {
		return customerService.selectCustomerById(id);
	}

	// 确认需改客户信息
	@RequestMapping(value = "customer/update.action")
	public @ResponseBody String updateCustomer(CustomerPojo customer) {
		customerService.updateCustomerById(customer);
		return "OK"; // 只有返回ok,前端才会弹窗显示修改成功
	}

}
