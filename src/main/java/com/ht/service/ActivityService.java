package com.ht.service;

import java.util.List;

import com.ht.pojo.TActivity;

public interface ActivityService extends BaseService<String, TActivity>{

	public abstract List<TActivity> findactivity(String column,String ifvalue);
}
