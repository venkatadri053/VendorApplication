package com.app.service;

import java.util.List;

import com.app.model.UploadFile;

public interface IDocumentService {

	public int saveDocument(UploadFile file);
	public List<Object[]> getIdAndNamesOnly();
	public UploadFile getObjetById(int fileId);
}
