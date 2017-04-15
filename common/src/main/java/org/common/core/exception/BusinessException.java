package org.common.core.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	// 业务类型
	private String bizType;
	// 业务代码
	private String bizCode;
	// 错误信息
	private String message;

	public BusinessException(String bizType, String bizCode, String message) {
		super(message);
		this.bizType = bizType;
		this.bizCode = bizCode;
		this.message = message;
	}

	public BusinessException(String message) {
		super(message);
		this.bizType = "";
		this.bizCode = "";
		this.message = message;
	}

	public BusinessException(String bizType, String message) {
		super(message);
		this.bizType = bizType;
		this.bizCode = "";
		this.message = message;
	}

	public BusinessException(int bizCode, String message) {
		super(message);
		this.bizType = "";
		this.bizCode = "";
		this.message = message;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
