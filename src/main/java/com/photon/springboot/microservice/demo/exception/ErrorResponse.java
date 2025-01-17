package com.photon.springboot.microservice.demo.exception;

public class ErrorResponse {

	String errorCode;
	String errorMsg;
	
	
	
	/**
	 * 
	 */
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param errorCode
	 * @param errorMsg
	 */
	public ErrorResponse(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}


	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
