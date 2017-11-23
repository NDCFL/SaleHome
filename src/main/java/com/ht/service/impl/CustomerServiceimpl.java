package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.CustomerDAO;
import com.ht.pojo.TCustomer;
import com.ht.service.CustomerService;

public class CustomerServiceimpl implements CustomerService{

	private CustomerDAO customerDAO;
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public TCustomer queryById(String id) {
		return customerDAO.queryById(id);
	}

	@Override
	public void update(TCustomer t) {
		customerDAO.update(t);
		
	}

	@Override
	public void add(TCustomer t) {
		customerDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return customerDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TCustomer t) {
		customerDAO.delete(t);
		
	}

	@Override
	public List<TCustomer> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return customerDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TCustomer> findcustor(String column, String ifvalue) {
		return customerDAO.findcustor(column, ifvalue);
	}

	@Override
	public void buyhouse(TCustomer t) {
		customerDAO.buyhouse(t);
		
	}

	@Override
	public void upfact(TCustomer t) {
		customerDAO.upfact(t);
		
	}

	@Override
	public List<TCustomer> addcomment(DetachedCriteria dc) {
		return customerDAO.addcomment(dc);
	}

}
