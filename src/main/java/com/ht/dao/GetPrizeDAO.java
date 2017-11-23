package com.ht.dao;

import java.util.List;

import com.ht.pojo.TGetPrize;

public interface GetPrizeDAO extends BaseDAO<String, TGetPrize> {

	public abstract List<TGetPrize> findlist(String column,String ifvalue);
	
}
