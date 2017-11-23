package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.TArticleTypeDAO;
import com.ht.pojo.TArticleType;
import com.ht.service.TArticleTypeService;

public class TArticleTypeServiceimpl implements TArticleTypeService{

	private TArticleTypeDAO tArticleTypeDAO;
	
	public TArticleTypeDAO gettArticleTypeDAO() {
		return tArticleTypeDAO;
	}

	public void settArticleTypeDAO(TArticleTypeDAO tArticleTypeDAO) {
		this.tArticleTypeDAO = tArticleTypeDAO;
	}

	@Override
	public TArticleType queryById(String id) {
		return tArticleTypeDAO.queryById(id);
	}

	@Override
	public void update(TArticleType t) {
		tArticleTypeDAO.update(t);
		
	}

	@Override
	public void add(TArticleType t) {
		tArticleTypeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return tArticleTypeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TArticleType t) {
		tArticleTypeDAO.delete(t);
		
	}

	@Override
	public List<TArticleType> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return tArticleTypeDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TArticleType> findtype() {
		return tArticleTypeDAO.findtype();
	}

}
