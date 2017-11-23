package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.GetPrizeDAO;
import com.ht.pojo.TGetPrize;
import com.ht.service.GetPrizeService;

public class GetPrizeServiceimpl implements GetPrizeService{

	private GetPrizeDAO getPrizeDAO;
	public GetPrizeDAO getGetPrizeDAO() {
		return getPrizeDAO;
	}

	public void setGetPrizeDAO(GetPrizeDAO getPrizeDAO) {
		this.getPrizeDAO = getPrizeDAO;
	}

	@Override
	public TGetPrize queryById(String id) {
		return getPrizeDAO.queryById(id);
	}

	@Override
	public void update(TGetPrize t) {
		getPrizeDAO.update(t);
	}

	@Override
	public void add(TGetPrize t) {
		getPrizeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return getPrizeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TGetPrize t) {
		getPrizeDAO.delete(t);
	}

	@Override
	public List<TGetPrize> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return getPrizeDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TGetPrize> findlist(String column, String ifvalue) {
		return getPrizeDAO.findlist(column, ifvalue);
	}

	
}
