package org.common.core.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.common.core.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//申明是个切面
@Aspect
// 申明是个spring管理的bean
@Component
@Order(1)
public class LoggingAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	// 申明一个切点 里面是 execution表达式
	@Pointcut("execution(public * org.gateway.controller.*.*(..))")
	private void controllerAspect() {
	}

	// 请求method前打印内容
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();

		// 打印请求内容
		log.info("url=" + request.getRequestURL().toString());
		log.info("method=" + request.getMethod());
		log.info("signature=" + joinPoint.getSignature());
		log.info("arguments=" + Arrays.toString(joinPoint.getArgs()));
	}

	// 在方法执行完结后打印返回内容
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void methodAfterReturing(Object o) {
		log.info("Response:" + JsonUtils.beanToJson(o));
	}
}
