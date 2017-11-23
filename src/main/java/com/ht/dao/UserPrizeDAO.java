package com.ht.dao;

import java.util.List;

import com.ht.pojo.TUserprize;

public interface UserPrizeDAO extends BaseDAO<String, TUserprize>{

	public abstract List<TUserprize> finduserprize(String column,String ifvalue);
	public abstract double salary(String employeeid);
}
