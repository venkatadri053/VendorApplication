package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.model.UploadFile;
import com.app.service.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService{
	@Autowired
	private IDocumentDao dao;
	
	@Override
	public int saveDocument(UploadFile file) {
		return dao.saveDocument(file);
	}
	

	@Override
	public List<Object[]> getIdAndNamesOnly() {
		return dao.getIdAndNamesOnly();
	}
	
	@Override
	public UploadFile getObjetById(int fileId) {
		return dao.getObjetById(fileId);
	}
	
}
