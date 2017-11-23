package com.ht.service;

import java.util.List;

import com.ht.pojo.TUserprize;

public interface UserPrizeService extends BaseService<String, TUserprize>{

	public abstract List<TUserprize> finduserprize(String column,String ifvalue);
	public abstract double salary(String employeeid);
}
