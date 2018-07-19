package com.itheima.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.ssm.mapper.BaseDictDao;
import com.itheima.ssm.pojo.BaseDictPojo;

@Service
// @Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Resource
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDictPojo> selectBaseDictListByCode(String code) {
		return baseDictDao.selectBaseDictListByCode(code);
	}

}
