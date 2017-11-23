package com.ht.service;

import java.util.List;

import com.ht.pojo.TMission;

public interface MissionService extends BaseService<String, TMission>{

	public abstract List<TMission> findmission(String column,String ifvalue);
	public abstract void updatelastquentity(TMission t);
}
