package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.UserPrizeDAO;
import com.ht.pojo.TUserprize;
import com.ht.service.UserPrizeService;

public class UserPrizeServiceimpl implements UserPrizeService{

	private UserPrizeDAO userPrizeDAO;
	public UserPrizeDAO getUserPrizeDAO() {
		return userPrizeDAO;
	}

	public void setUserPrizeDAO(UserPrizeDAO userPrizeDAO) {
		this.userPrizeDAO = userPrizeDAO;
	}

	@Override
	public TUserprize queryById(String id) {
		return userPrizeDAO.queryById(id);
	}

	@Override
	public void update(TUserprize t) {
		userPrizeDAO.update(t);
	}

	@Override
	public void add(TUserprize t) {
		userPrizeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return userPrizeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TUserprize t) {
		userPrizeDAO.delete(t);
		
	}

	@Override
	public List<TUserprize> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return userPrizeDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TUserprize> finduserprize(String column, String ifvalue) {
		return userPrizeDAO.finduserprize(column, ifvalue);
	}

	@Override
	public double salary(String employeeid) {
		return userPrizeDAO.salary(employeeid);
	}

}
