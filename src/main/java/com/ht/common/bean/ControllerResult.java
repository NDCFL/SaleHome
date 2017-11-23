package com.ht.common.bean;

public class ControllerResult {
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	private String result; 
	private String message; 
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ControllerResult getSuccessResult(String messgae) {
		ControllerResult controllerResult = new ControllerResult();
		controllerResult.setResult(SUCCESS);
		controllerResult.setMessage(messgae);
		return controllerResult;
	}
	
	public static ControllerResult getFailResult(String messgae) {
		ControllerResult controllerResult = new ControllerResult();
		controllerResult.setResult(FAIL);
		controllerResult.setMessage(messgae);
		return controllerResult;
	}

}
