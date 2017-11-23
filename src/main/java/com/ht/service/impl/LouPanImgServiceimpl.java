package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.LouPanImgDAO;
import com.ht.pojo.TBuildingsImg;
import com.ht.service.LouPanImgService;


public class LouPanImgServiceimpl implements LouPanImgService{

	private LouPanImgDAO louPanImgDAO;
	
	
	public LouPanImgDAO getLouPanImgDAO() {
		return louPanImgDAO;
	}


	public void setLouPanImgDAO(LouPanImgDAO louPanImgDAO) {
		this.louPanImgDAO = louPanImgDAO;
	}


	public TBuildingsImg queryById(String id) {
		return louPanImgDAO.queryById(id);
	}

	
	public void update(TBuildingsImg t) {
		louPanImgDAO.update(t);
		
	}

	
	public void add(TBuildingsImg t) {
		louPanImgDAO.add(t);
		
	}

	
	public int count(String column, String ifvalue) {
		return louPanImgDAO.count(column, ifvalue);
	}

	
	public void delete(TBuildingsImg t) {
		louPanImgDAO.delete(t);
		
	}

	
	public List<TBuildingsImg> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return louPanImgDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TBuildingsImg> loupanimglist() {
		return louPanImgDAO.loupanimglist();
	}

	
	public List<TBuildingsImg> findloupanimg(String idString) {
		return louPanImgDAO.findloupanimg(idString);
	}

	
}
