package com.ht.service;

import java.util.List;

import com.ht.pojo.TEmployee;

public interface EmployeeService extends BaseService<String, TEmployee>{

	public  abstract List<TEmployee> empList(String column,String ifvalue);
	public  abstract void updateinfo(TEmployee t);
	public abstract void updatestatus(TEmployee t);
	public abstract void updateemployee(TEmployee t);
}
