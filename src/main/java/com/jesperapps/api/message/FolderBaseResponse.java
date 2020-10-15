package com.jesperapps.api.message;

import com.jesperapps.api.JSONmodel.FolderJSON;

public class FolderBaseResponse extends BaseResponse{
	
	private FolderJSON folders;
	
	public FolderBaseResponse(int statuscode,String description) {
		this.statusCode=statuscode;
		this.description=description;
		
	}

	public FolderBaseResponse() {
		
	}

	public FolderJSON getFolders() {
		return folders;
	}

	public void setFolders(FolderJSON folders) {
		this.folders = folders;
	}
		
	
	
}
