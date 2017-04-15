package org.service1.service.impl;

import org.service1.service.ServiceTest;
import org.springframework.util.Assert;

public class ServiceTestImpl implements ServiceTest{

	@Override
	public String sayHello(String content){
		Assert.notNull(content);
		return content;
	}

}
