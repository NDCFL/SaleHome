package com.ht.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;

public interface LouDongDAO extends BaseDAO<String, TBuilding>{

	public abstract List<TBuilding>  loudonglist(String column,String ifvalue);
	public abstract List<TBuildings> findloupan(String jxsidString);
	public abstract List<TBuilding> findloudong(String idString);
	public abstract int pagecount(DetachedCriteria dc);
}
