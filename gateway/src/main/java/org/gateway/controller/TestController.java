package org.gateway.controller;

import org.common.core.exception.BusinessException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * <p>LoggingAspect </p>
 * <p>描述: </p>
 *   @author Sean.Chan
 *   @date 2017年4月15日下午10:58:15
 */
@RestController
@RequestMapping("/test")
public class TestController {

	//@Autowired
//	@Reference
//	private TestService1 testService1;
//
//	//@Autowired
//	@Reference
//	private TestService2 testService2;

	@RequestMapping("/hello/{content}")
	@ResponseBody
	public String hello(@PathVariable String content) throws BusinessException{
		Assert.notNull(content);
		if(content.equals("aa")){
			throw new BusinessException("aaaaa");
		}
		return content;
	}

	@RequestMapping("/show")
	@ResponseBody
	public double showmoney() {
		return 0;
	}

}