package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.common.bean.Pager4EasyUI;
import com.ht.dao.LoginRegisterDAO;
import com.ht.pojo.TUser;
import com.ht.pojo.TBuildings;
import com.ht.service.LoginRegisterService;

public class LoginRegisterServiceimpl implements LoginRegisterService{

	private LoginRegisterDAO loginRegisterDAO;
	public LoginRegisterDAO getLoginRegisterDAO() {
		return loginRegisterDAO;
	}

	public void setLoginRegisterDAO(LoginRegisterDAO loginRegisterDAO) {
		this.loginRegisterDAO = loginRegisterDAO;
	}

	
	public TUser queryById(String id) {
		return loginRegisterDAO.queryById(id);
	}

	
	public void update(TUser t) {
		loginRegisterDAO.update(t);
		
	}

	
	public void add(TUser t) {
		loginRegisterDAO.add(t);
		
	}

	
	public int count(String column,String ifvalue) {
		return loginRegisterDAO.count(column, ifvalue);
	}

	
	public List<TUser> findaccount(String phone) {
		return loginRegisterDAO.findaccount(phone);
	}

	
	public void delete(TUser t) {
		loginRegisterDAO.delete(t);
		
	}

	
	public List<TUser> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return loginRegisterDAO.pagelist(dc, startpage, pagesize);
	}
	
	
}
