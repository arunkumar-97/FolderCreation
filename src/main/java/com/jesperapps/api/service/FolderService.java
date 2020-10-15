package com.jesperapps.api.service;

import com.jesperapps.api.JSONmodel.FolderJSON;
import com.jesperapps.api.message.FolderRequestEntity;

import com.jesperapps.api.model.Folder;

public interface FolderService {

	public FolderJSON createFolder(FolderRequestEntity folderRequestEntity);

	public Folder fromfolderId(Integer folderId);

	public void saveFolder(Folder folderFromDatabase);

	public Iterable<FolderJSON> findAll();

	public Folder findById(int folderId);

	public void deleteFolder(Folder folderFromId);

	

}
