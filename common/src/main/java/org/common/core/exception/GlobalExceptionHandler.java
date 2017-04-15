package org.common.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.common.core.entity.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 捕获异常统一处理
 * 
 * @description TODO
 * @author chen.gs
 * @create date 2016年4月28日
 * @modified by
 * @modify date
 * @version v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public MessageResponse handleBizExp(HttpServletRequest request, BusinessException ex) {

		log.error("系统异常  " + ex.getMessage());

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);

		String stackTrace = sw.toString();
		log.error(stackTrace);

		MessageResponse msgResponse = new MessageResponse();
		msgResponse.setMessage(ex.getMessage());
		msgResponse.setStackTrace(stackTrace);
		msgResponse.setCode(ex.getBizCode());

		return msgResponse;
	}

	@ExceptionHandler(SQLException.class)
	public ModelAndView handSql(Exception ex) {
		log.info("SQL Exception " + ex.getMessage());
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", ex.getMessage());
		mv.setViewName("sql_error");
		return mv;
	}
}
