package com.app.dao;

import java.util.List;

import com.app.model.UploadFile;

public interface IDocumentDao {

	public int saveDocument(UploadFile file);
	public List<Object[]> getIdAndNamesOnly();
	public UploadFile getObjetById(int fileId);
	
}
