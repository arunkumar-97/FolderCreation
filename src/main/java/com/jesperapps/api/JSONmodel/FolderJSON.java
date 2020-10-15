package com.jesperapps.api.JSONmodel;

import com.jesperapps.api.model.Folder;

public class FolderJSON {
	
	private Integer folderId;
	private String folderName;
	private String status;
	private UserJSON user;
	
	
	
	public FolderJSON() {
		
	}
	
	public FolderJSON(Folder folder) {
		this.folderId=folder.getFolderId();
		this.folderName=folder.getFolderName();
		this.status=folder.getStatus();
		this.user=new UserJSON(folder.getUser());

	}
	
	
	
	
	public FolderJSON(Integer folderId2, String folderName2, String status2, UserJSON user2) {
		this.folderId=folderId2;
		this.folderName=folderName2;
		this.status=status2;
		this.user=user2;
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
