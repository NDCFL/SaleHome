package com.ht.dao;

import java.util.List;

import com.ht.pojo.TMission;

public interface MissionDAO extends BaseDAO<String, TMission>{

	public abstract List<TMission> findmission(String column,String ifvalue);
	public abstract void updatelastquentity(TMission t);
}
