package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.UserDAO;
import com.ht.pojo.TUser;
import com.ht.service.UserService;

public class UserServiceimpl implements UserService{

	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public TUser queryById(String id) {
		return userDAO.queryById(id);
	}

	
	public void update(TUser t) {
		userDAO.update(t);
		
	}

	
	public void add(TUser t) {
		userDAO.add(t);
		
	}

	
	public int count(String column, String ifvalue) {
		return userDAO.count(column, ifvalue);
	}

	
	public void delete(TUser t) {
		userDAO.delete(t);
		
	}

	
	public List<TUser> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return userDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TUser> finduser() {
		return userDAO.finduser();
	}

	
	public void updateuserinfo(TUser t) {
		userDAO.updateuserinfo(t);
		
	}

	
	public void updateuserpwd(TUser user) {
		userDAO.updateuserpwd(user);		
	}

	@Override
	public List<TUser> finduser(String column, String ifvalue) {
		return userDAO.finduser(column,ifvalue);
	}

}
