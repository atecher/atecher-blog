package com.atecher.blog.web.util;

public class ResponseResult {
	
	public ResponseResult(String code){
		this.code=code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String code;
	private String message;

}
