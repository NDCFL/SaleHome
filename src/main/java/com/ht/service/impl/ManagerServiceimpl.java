package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.ManagerDAO;
import com.ht.pojo.TManager;
import com.ht.service.ManagerService;

public class ManagerServiceimpl implements ManagerService{

	private ManagerDAO managerDAO;
	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	@Override
	public TManager queryById(String id) {
		return managerDAO.queryById(id);
	}

	@Override
	public void update(TManager t) {
		managerDAO.update(t);
		
	}

	@Override
	public void add(TManager t) {
		managerDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return managerDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TManager t) {
		managerDAO.delete(t);
		
	}

	@Override
	public List<TManager> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return managerDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TManager> managerList(String colum, String ifvalue) {
		return managerDAO.managerList(colum, ifvalue);
	}

	@Override
	public List<TManager> findManager(String colum, String ifvalue) {
		return managerDAO.findManager(colum, ifvalue);
	}

	@Override
	public void updateManager(TManager manager) {
		managerDAO.updateManager(manager);
		
	}

	@Override
	public void updatepwd(TManager manager) {
		managerDAO.updatepwd(manager);
	}

	@Override
	public void updatestatus(TManager manager) {
		managerDAO.updatestatus(manager);
		
	}

}
