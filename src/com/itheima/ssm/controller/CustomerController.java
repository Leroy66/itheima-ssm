package com.itheima.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping(value = "/customer/list")
	public String list() {

		return "customer";
	}

}
