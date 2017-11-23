package com.ht.dao;

import java.util.List;

import com.ht.pojo.TPage;

public interface PageDAO extends BaseDAO<String, TPage>{

	public abstract List<TPage> findpage(String column,String ifvalue);
}
