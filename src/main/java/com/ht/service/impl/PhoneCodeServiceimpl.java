package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.PhoneCodeDAO;
import com.ht.pojo.TPhoneCode;
import com.ht.service.PhoneCodeService;

public class PhoneCodeServiceimpl implements PhoneCodeService{

	private PhoneCodeDAO phoneCodeDAO;
	public PhoneCodeDAO getPhoneCodeDAO() {
		return phoneCodeDAO;
	}

	public void setPhoneCodeDAO(PhoneCodeDAO phoneCodeDAO) {
		this.phoneCodeDAO = phoneCodeDAO;
	}

	@Override
	public TPhoneCode queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TPhoneCode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(TPhoneCode t) {
		phoneCodeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return phoneCodeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TPhoneCode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TPhoneCode> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

}
