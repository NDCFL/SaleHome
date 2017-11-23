package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.HouseDAO;
import com.ht.pojo.TBuilding;
import com.ht.pojo.THouse;
import com.ht.service.HouseService;

public class HouseServiceimpl implements HouseService{

	private HouseDAO houseDAO;
	public HouseDAO getHouseDAO() {
		return houseDAO;
	}

	public void setHouseDAO(HouseDAO houseDAO) {
		this.houseDAO = houseDAO;
	}

	
	public THouse queryById(String id) {
		return houseDAO.queryById(id);
	}

	
	public void update(THouse t) {
		houseDAO.update(t);
	}

	
	public void add(THouse t) {
		houseDAO.add(t);
	}

	
	public int count(String column, String ifvalue) {
		return houseDAO.count(column, ifvalue);
	}

	
	public void delete(THouse t) {
		houseDAO.delete(t);
	}

	
	public List<THouse> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return houseDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TBuilding> buildlist(String column, String ifvlue) {
		return houseDAO.buildlist(column, ifvlue);
	}

	
	public List<THouse> findhouse(String column, String ifvlue) {
		return houseDAO.findhouse(column, ifvlue);
	}

	@Override
	public int pagecount(DetachedCriteria dc) {
		return houseDAO.pagecount(dc);
	}

}
