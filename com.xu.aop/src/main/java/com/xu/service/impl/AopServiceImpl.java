package com.xu.service.impl;

import org.springframework.stereotype.Service;

import com.xu.service.AopService;

@Service("aopService")
public class AopServiceImpl implements AopService {

	public String doSth(String a, String b) {
		return "参数1:"+a +",参数2:"+b;
	}

}
