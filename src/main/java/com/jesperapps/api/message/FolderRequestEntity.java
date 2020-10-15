package com.jesperapps.api.message;

import com.jesperapps.api.JSONmodel.UserJSON;


public class FolderRequestEntity extends BaseResponse{

	private Integer folderId;
	private String folderName;
	private String status;
	private UserJSON user;

	
	
	
	public FolderRequestEntity(int i, String string) {
		super(i,string);
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
