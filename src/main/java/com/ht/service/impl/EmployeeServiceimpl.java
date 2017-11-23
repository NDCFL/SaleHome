package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.EmployeeDAO;
import com.ht.pojo.TEmployee;
import com.ht.service.EmployeeService;

public class EmployeeServiceimpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public TEmployee queryById(String id) {
		return employeeDAO.queryById(id);
	}

	@Override
	public void update(TEmployee t) {
		employeeDAO.update(t);
		
	}

	@Override
	public void add(TEmployee t) {
		employeeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return employeeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TEmployee t) {
		employeeDAO.delete(t);
		
	}

	@Override
	public List<TEmployee> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return employeeDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TEmployee> empList(String column, String ifvalue) {
		return employeeDAO.empList(column, ifvalue);
	}

	@Override
	public void updateinfo(TEmployee t) {
		employeeDAO.updateinfo(t);
		
	}

	@Override
	public void updatestatus(TEmployee t) {
		employeeDAO.updatestatus(t);
		
	}

	@Override
	public void updateemployee(TEmployee t) {
		employeeDAO.updateemployee(t);
	}

}
