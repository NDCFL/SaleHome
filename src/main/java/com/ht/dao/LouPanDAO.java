package com.ht.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.TBuildings;

public interface LouPanDAO extends BaseDAO<String, TBuildings>{

	public abstract List<TBuildings> buildingslist(String column,String ifvalue);
	public abstract List<TBuildings> findloupan(String idString);
	public abstract int count();
	public abstract List<TBuildings> likebuildings(String column,String ifvalue,int startpage,int pagesize);
	public abstract int likecount(String column,String ifvalue);
	public abstract List<TBuildings> likebuildings(String column,String ifvalue);
	public abstract List<TBuildings> baobiao();
	public abstract List<TBuildings> loupanlist();
	public abstract int pagecount(DetachedCriteria dc);
}
