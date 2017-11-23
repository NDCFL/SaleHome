package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.SaleDAO;
import com.ht.pojo.TSale;
import com.ht.service.SaleService;

public class SaleServiceimpl implements SaleService{

	private SaleDAO saleDAO;
	public SaleDAO getSaleDAO() {
		return saleDAO;
	}

	public void setSaleDAO(SaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}

	@Override
	public TSale queryById(String id) {
		return saleDAO.queryById(id);
	}

	@Override
	public void update(TSale t) {
		saleDAO.update(t);
		
	}

	@Override
	public void add(TSale t) {
		saleDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return saleDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TSale t) {
		saleDAO.delete(t);
		
	}

	@Override
	public List<TSale> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return saleDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TSale> findsale(String column, String ifvalue) {
		return saleDAO.findsale(column, ifvalue);
	}

	@Override
	public void shenhe(TSale sale) {
		saleDAO.shenhe(sale);
		
	}

	@Override
	public int count() {
		return saleDAO.count();
	}

	@Override
	public List<TSale> baobiaolist() {
		return saleDAO.baobiaolist();
	}

}
