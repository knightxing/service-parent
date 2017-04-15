package org.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
	public String hello(@PathVariable String content) {
		Assert.notNull(content);
		//String result = testService1.sayHello(content); // ִ
		//return result;
		return content;
	}

//	@RequestMapping("/showmoney")
//	@ResponseBody
//	public double showmoney() {
//		return testService2.showMoney();
//	}

}