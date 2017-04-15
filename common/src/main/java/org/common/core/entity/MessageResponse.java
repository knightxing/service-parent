package org.common.core.entity;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
public class MessageResponse implements Serializable{

	private String message;
	
	private String stackTrace;
	
	private String code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	
	
	
	
	
	
}
