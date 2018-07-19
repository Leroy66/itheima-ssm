package com.itheima.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.ssm.pojo.BaseDictPojo;
import com.itheima.ssm.service.BaseDictService;

@Controller
public class CustomerController {

	@Resource
	private BaseDictService baseDictService;

	//客户来源
	@Value("${BASE_DICT_RFOM_TYPR}")
	private String BASE_DICT_RFOM_TYPR;
	//所属行业
	@Value("${BASE_DICT_INDUSTRY_TYPE}")
	private String BASE_DICT_INDUSTRY_TYPE;
	//客户等级
	@Value("${BASE_DICT_LEVEL_TYPE}")
	private String BASE_DICT_LEVEL_TYPE;

	@RequestMapping(value = "/customer/list")
	public String list(Model model) {

		List<BaseDictPojo> fromType = baseDictService.selectBaseDictListByCode(BASE_DICT_RFOM_TYPR);
		List<BaseDictPojo> industryType = baseDictService.selectBaseDictListByCode(BASE_DICT_INDUSTRY_TYPE);
		List<BaseDictPojo> levelType = baseDictService.selectBaseDictListByCode(BASE_DICT_LEVEL_TYPE);

		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		return "customer";
	}

}
