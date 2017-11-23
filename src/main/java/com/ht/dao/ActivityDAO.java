package com.ht.dao;

import java.util.List;

import com.ht.pojo.TActivity;

public interface ActivityDAO extends BaseDAO<String, TActivity>{

	public abstract List<TActivity> findactivity(String column,String ifvalue);
}
