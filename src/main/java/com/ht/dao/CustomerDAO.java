package com.ht.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.TCustomer;

public interface CustomerDAO extends BaseDAO<String, TCustomer>{

	public abstract List<TCustomer> findcustor(String column,String ifvalue);
	public abstract void buyhouse(TCustomer t);
	public abstract void upfact(TCustomer t);
	public abstract List<TCustomer> addcomment(DetachedCriteria dc);
}
