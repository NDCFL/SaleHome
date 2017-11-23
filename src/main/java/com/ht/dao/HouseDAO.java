package com.ht.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.TBuilding;
import com.ht.pojo.THouse;

public interface HouseDAO extends BaseDAO<String, THouse>{

	public abstract List<TBuilding> buildlist(String column,String ifvlue);
	public abstract List<THouse> findhouse(String column,String ifvlue);
	public abstract int pagecount(DetachedCriteria dc);
}
