package com.ht.dao;

import java.util.List;

import com.ht.pojo.TArticleType;

public interface TArticleTypeDAO extends BaseDAO<String, TArticleType>{
	
	public abstract List<TArticleType> findtype();
	
}
