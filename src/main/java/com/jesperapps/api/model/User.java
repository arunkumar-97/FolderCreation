package com.jesperapps.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	private Integer userId;
	private String userName;
	
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Folder> folder;
	
	
	
	
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
	public List<Folder> getFolder() {
		return folder;
	}
	public void setFolder(List<Folder> folder) {
		this.folder = folder;
	}
	
	
	

}
