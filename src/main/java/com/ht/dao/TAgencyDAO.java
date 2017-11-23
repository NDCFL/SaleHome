package com.ht.dao;

import java.util.List;

import com.ht.pojo.TAgency;

public interface TAgencyDAO extends BaseDAO<String, TAgency>{

	public abstract List<TAgency> tagencylist(String column,String ifvalue);
	public abstract void changestatus(String column,String ifvalue,String id);
	public abstract void shenhe(TAgency tAgency);
	public abstract int likecount(String starttime,String endtime,String name);
	public abstract void updatelogo(TAgency t);
	public abstract void updatetagency(TAgency t);
}
