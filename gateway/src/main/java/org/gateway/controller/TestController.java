package org.gateway.controller;

import org.common.core.exception.BusinessException;
import org.service1.service.ServiceTest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * 
 * 
 * <p>
 * LoggingAspect
 * </p>
 * <p>
 * 描述:
 * </p>
 * 
 * @author Sean.Chan
 * @date 2017年4月15日下午10:58:15
 */
@RestController
@RequestMapping("/test")
public class TestController {

	// @Autowired
	@Reference
	private ServiceTest testService1;
	//
	// //@Autowired
	// @Reference
	// private TestService2 testService2;

	@RequestMapping("/hello/{content}")
	@ResponseBody
	public String hello(@PathVariable String content) throws BusinessException {
		Assert.notNull(content);
		return testService1.sayHello(content);
	}

	@RequestMapping("/show")
	@ResponseBody
	public double showmoney() {
		return 0;
	}

}