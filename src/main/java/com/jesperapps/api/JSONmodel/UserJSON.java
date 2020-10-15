package com.jesperapps.api.JSONmodel;

import com.jesperapps.api.model.User;

public class UserJSON {
	
	private Integer userId;
	private String userName;
	
	public UserJSON() {
		
	}
	public UserJSON(User user) {
		this.userId=user.getUserId();
		this.userName=user.getUserName();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
