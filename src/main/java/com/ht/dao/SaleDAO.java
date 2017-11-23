package com.ht.dao;

import java.util.List;

import com.ht.pojo.TSale;

public interface SaleDAO extends BaseDAO<String, TSale>{

	public abstract List<TSale> findsale(String column,String ifvalue);
	public abstract void shenhe(TSale sale);
	public abstract int count();
	public abstract List<TSale> baobiaolist();
}
