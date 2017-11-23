package com.ht.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.TAgencyDAO;
import com.ht.pojo.TAgency;
import com.ht.service.TAgencyService;

public class TAgencyServiceimpl implements TAgencyService {

	private TAgencyDAO tAgencyDAO;
	public TAgencyDAO gettAgencyDAO() {
		return tAgencyDAO;
	}

	public void settAgencyDAO(TAgencyDAO tAgencyDAO) {
		this.tAgencyDAO = tAgencyDAO;
	}

	
	public TAgency queryById(String id) {
		return tAgencyDAO.queryById(id);
	}

	
	public void update(TAgency t) {
		tAgencyDAO.update(t);
		
	}

	
	public void add(TAgency t) {
		tAgencyDAO.add(t);
		
	}

	
	public int count(String column, String ifvalue) {
		return tAgencyDAO.count(column, ifvalue);
	}

	
	public void delete(TAgency t) {
		tAgencyDAO.delete(t);
		
	}

	
	public List<TAgency> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return tAgencyDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TAgency> tagencylist(String column, String ifvalue) {
		return tAgencyDAO.tagencylist(column, ifvalue);
	}

	@Override
	public void changestatus(String column, String ifvalue, String id) {
		tAgencyDAO.changestatus(column, ifvalue, id);
		
	}

	@Override
	public void shenhe(TAgency tAgency) {
		tAgencyDAO.shenhe(tAgency);
		
	}

	@Override
	public int likecount(String starttime, String endtime, String name) {
		return tAgencyDAO.likecount(starttime, endtime, name);
	}

	@Override
	public void updatelogo(TAgency t) {
		tAgencyDAO.updatelogo(t);
		
	}

	@Override
	public void updatetagency(TAgency t) {
		tAgencyDAO.updatetagency(t);
		
	}

}
