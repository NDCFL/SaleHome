package com.ht.dao;

import java.util.List;

import com.ht.pojo.TEmployee;

public interface EmployeeDAO extends BaseDAO<String, TEmployee>{

	public abstract List<TEmployee> empList(String column,String ifvalue);
	public abstract void updateinfo(TEmployee t);
	public abstract void updatestatus(TEmployee t);
	public abstract void updateemployee(TEmployee t);
	
}
