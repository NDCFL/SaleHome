package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.LouDongDAO;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.service.LouDongService;

public class LouDongServiceimpl implements LouDongService{

	private LouDongDAO louDongDAO;
	public LouDongDAO getLouDongDAO() {
		return louDongDAO;
	}

	public void setLouDongDAO(LouDongDAO louDongDAO) {
		this.louDongDAO = louDongDAO;
	}

	
	public TBuilding queryById(String id) {
		return louDongDAO.queryById(id);
	}

	
	public void update(TBuilding t) {
		louDongDAO.update(t);
		
	}

	
	public void add(TBuilding t) {
		louDongDAO.add(t);
		
	}

	
	public int count(String column,String ifvalue) {
		return louDongDAO.count(column,ifvalue);
	}

	
	public void delete(TBuilding t) {
		louDongDAO.delete(t);
		
	}

	
	public List<TBuilding> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return louDongDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TBuilding> loudonglist(String column,String ifvalue) {
		return louDongDAO.loudonglist(column,ifvalue);
	}

	
	public List<TBuildings> findloupan(String jxsidString) {
		return louDongDAO.findloupan(jxsidString);
	}

	
	public List<TBuilding> findloudong(String idString) {
		return louDongDAO.findloudong(idString);
	}

	@Override
	public int pagecount(DetachedCriteria dc) {
		return louDongDAO.pagecount(dc);
	}

}
