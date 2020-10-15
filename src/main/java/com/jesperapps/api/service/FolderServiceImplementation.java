package com.jesperapps.api.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.api.JSONmodel.FolderJSON;

import com.jesperapps.api.message.FolderRequestEntity;

import com.jesperapps.api.model.Folder;
import com.jesperapps.api.model.User;
import com.jesperapps.api.repository.FolderRepository;
import com.jesperapps.api.repository.UserRepository;
import com.jesperapps.api.utils.StatusFolder;

@Service
public class FolderServiceImplementation implements FolderService{
	
	
	
	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public FolderJSON createFolder(FolderRequestEntity folderRequestEntity) {
		
	
	
		Folder folder=new Folder();
		
		folder.setFolderName(folderRequestEntity.getFolderName());
		folder.setStatus(folderRequestEntity.getStatus());
		if(folderRequestEntity.getUser()!=null) {
		User newUser=userRepository.findByUserId(folderRequestEntity.getUser().getUserId());
		folder.setUser(newUser);
		}
		
		folderRepository.save(folder);
		
		return new FolderJSON(folder);
	}

	@Override
	public Folder fromfolderId(Integer folderId) {
		// TODO Auto-generated method stub
		return folderRepository.findByFolderId(folderId);
	}

	@Override
	public void saveFolder(Folder folderFromDatabase) {
		// TODO Auto-generated method stub
		folderRepository.save(folderFromDatabase);
	}

	@Override

	public List<FolderJSON> findAll()
	{
		return folderRepository.findByStatusIsNot(StatusFolder.DELETED);
		
	}

	@Override
	public Folder findById(int folderId) {
		
		return folderRepository.findByFolderId(folderId);
	}

	@Override
	public void deleteFolder(Folder folderFromId) 
	{
		folderFromId.setStatus(StatusFolder.DELETED);
		this.saveFolder(folderFromId);
	}


}
