package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.HistoryDAO;
import com.ht.pojo.TBaobiao;
import com.ht.pojo.THistory;
import com.ht.service.HistoryService;

public class HistoryServiceimpl implements HistoryService{

	private HistoryDAO historyDAO;
	public HistoryDAO getHistoryDAO() {
		return historyDAO;
	}

	public void setHistoryDAO(HistoryDAO historyDAO) {
		this.historyDAO = historyDAO;
	}

	@Override
	public THistory queryById(String id) {
		return null;
	}

	@Override
	public void update(THistory t) {
		
	}

	@Override
	public void add(THistory t) {
		historyDAO.add(t);
			
	}

	@Override
	public int count(String column, String ifvalue) {
		return historyDAO.count(column, ifvalue);
	}

	@Override
	public void delete(THistory t) {
		historyDAO.delete(t);
		
	}

	@Override
	public List<THistory> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return historyDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<THistory> historylist() {
		return historyDAO.historylist();
	}

	@Override
	public int pagecount(DetachedCriteria dc) {
		return historyDAO.pagecount(dc);
	}

}
