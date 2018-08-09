package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="DOC_TAB")
public class UploadFile {
	@Id
	@Column(name="fid")
	private int fileId;
	@Column(name="fname")
	private String fileName;
	@Lob //Binary Large Object=>BLOB
	@Column(name="data")
	private byte[] fileData;
	
	public UploadFile() {
		super();
	}
	public UploadFile(int fileId) {
		super();
		this.fileId = fileId;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "UploadFile [fileId=" + fileId + ", fileName=" + fileName
				+ ", fileData=" + Arrays.toString(fileData) + "]";
	}
	
	
	
}
