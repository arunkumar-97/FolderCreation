package com.jesperapps.api.message;

import com.jesperapps.api.JSONmodel.FolderJSON;
import com.jesperapps.api.JSONmodel.UserJSON;


public class FolderResponseEntity {


	private Integer folderId;
	private String folderName;
	private String status;
	private UserJSON user;
	
	
	public FolderResponseEntity() {
		
	}
	

	public FolderResponseEntity(FolderJSON createdFolder) {
		this.folderId=createdFolder.getFolderId();
		this.folderName=createdFolder.getFolderName();
		this.status=createdFolder.getStatus();
		if(createdFolder.getUser()!=null) {
			this.setUser(createdFolder.getUser());
		}

	}
	public Integer getFolderId() {
		return folderId;
	}
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public UserJSON getUser() {
		return user;
	}


	public void setUser(UserJSON user) {
		this.user = user;
	}
	
	
	
	
	
}
