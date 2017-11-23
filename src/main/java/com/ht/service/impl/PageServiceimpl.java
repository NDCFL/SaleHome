package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.PageDAO;
import com.ht.pojo.TPage;
import com.ht.service.PageService;

public class PageServiceimpl implements PageService{

	private PageDAO pageDAO;
	public PageDAO getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	@Override
	public TPage queryById(String id) {
		return pageDAO.queryById(id);
	}

	@Override
	public void update(TPage t) {
		pageDAO.update(t);
		
	}

	@Override
	public void add(TPage t) {
		pageDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return pageDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TPage t) {
		pageDAO.delete(t);
		
	}

	@Override
	public List<TPage> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TPage> findpage(String column, String ifvalue) {
		return pageDAO.findpage(column, ifvalue);
	}

}
