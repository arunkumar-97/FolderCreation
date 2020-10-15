package com.jesperapps.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.api.JSONmodel.FolderJSON;
import com.jesperapps.api.JSONmodel.UserJSON;
import com.jesperapps.api.message.FolderBaseResponse;
import com.jesperapps.api.message.FolderRequestEntity;
import com.jesperapps.api.message.FolderResponseEntity;
import com.jesperapps.api.model.Folder;
import com.jesperapps.api.service.FolderService;


@RestController
public class FolderController {
	
	@Autowired
	private FolderService folderService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/folder")
	public ResponseEntity createFolder(@RequestBody FolderRequestEntity folderRequestEntity  ) {
		
		
		FolderJSON createdFolder=folderService.createFolder(folderRequestEntity);

		if(createdFolder !=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new FolderResponseEntity(createdFolder));
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new FolderResponseEntity() );
		}
		
		
	}
	
	@PutMapping("/folder/{folderId}")
	public FolderBaseResponse updateClassName( @RequestBody FolderRequestEntity folderRequestEntity,@PathVariable Integer folderId)
	{
		FolderBaseResponse response = new FolderBaseResponse(409,"No such Id found");
		FolderJSON folderResponse=new FolderJSON();
		response.setFolders(folderResponse);
		if(folderId != null) 
		{
			Folder folderFromDatabase = folderService.fromfolderId(folderId);
			if(folderFromDatabase != null) 
			{

				folderFromDatabase.setFolderName(folderRequestEntity.getFolderName());

				folderService.saveFolder(folderFromDatabase) ;
				response.setDescription("Successfully updated");
				response.setStatusCode(200);
				folderResponse.setFolderId(folderFromDatabase.getFolderId());
				folderResponse.setFolderName(folderRequestEntity.getFolderName());
				folderResponse.setStatus(folderFromDatabase.getStatus());
				folderResponse.setUser(new UserJSON(folderFromDatabase.getUser()));
			}
		}

		return response;
	}
	

	@GetMapping("/folder")
	public List<FolderJSON>  listAllFolders()
	{
		List<FolderJSON> response=new ArrayList<>();
		

		folderService.findAll().forEach(folder->{
			response.add(new FolderJSON(folder.getFolderId(),folder.getFolderName(),folder.getStatus(),folder.getUser()));
		});
		return response;
	}
	
	@GetMapping("/folder/{folderId}")
	public FolderJSON viewClass(@PathVariable int folderId)
	{
		Folder folder = folderService.findById(folderId);
		FolderJSON folderResponse= new FolderJSON();
		if(folder != null)
		{
			folderResponse.setFolderId(folder.getFolderId());
			folderResponse.setFolderName(folder.getFolderName());
			folderResponse.setStatus(folder.getStatus());
			folderResponse.setUser(new UserJSON(folder.getUser()));
			
		}
		return folderResponse;

	}
	
	@DeleteMapping("/folder/{folderId}")
	public FolderRequestEntity deleteFolderById(@PathVariable int folderId)
	{
		FolderRequestEntity response = new FolderRequestEntity(409, "No such Id found");

		Folder folderFromId = folderService.fromfolderId(folderId);
		if(folderFromId != null)
		{
			folderService.deleteFolder(folderFromId);
			response.setFolderId(folderFromId.getFolderId());
			response.setFolderName(folderFromId.getFolderName());
			response.setStatus(folderFromId.getStatus());
			response.setUser(new UserJSON(folderFromId.getUser()));
			response.setDescription("deleted Successfully");
			response.setStatusCode(200);
		}
		return response;

	}


}
