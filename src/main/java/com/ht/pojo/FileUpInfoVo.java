package com.ht.pojo;

import java.io.File;
import java.io.Serializable;

public class FileUpInfoVo implements Serializable{

	private File doc; //封装上传文件的属性
	private String docFileName; //封装上传文件的名称属性
	private String docContentType; //封装上传文件的类型属性
	private String filepath; //保存路径
	private String filename; //保存的文件名
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
