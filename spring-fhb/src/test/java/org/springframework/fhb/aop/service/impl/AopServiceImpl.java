package org.springframework.fhb.aop.service.impl;

import org.springframework.fhb.aop.service.AopService;

/**
 * @Author huabao.fang
 * @Date 11:14 2019-09-29
 **/
public class AopServiceImpl implements AopService {


	@Override
	public String sayHi(String name){
		return "hi " + name;
	}

}
