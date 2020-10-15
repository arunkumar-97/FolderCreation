package com.jesperapps.api.message;

public abstract class BaseResponse {
	
	public Integer statusCode;
	public String description;
	
	public BaseResponse() {
		
	}

	public BaseResponse(Integer statusCode, String description) {
		
		this.statusCode = statusCode;
		this.description = description;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
