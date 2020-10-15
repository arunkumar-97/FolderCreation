package com.jesperapps.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.api.JSONmodel.FolderJSON;

import com.jesperapps.api.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer>{

	void save(FolderJSON folder);

	Folder findByFolderId(Integer folderId);

	List<FolderJSON> findByStatusIsNot(String dELETED);


}
