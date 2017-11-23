package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.ActivityDAO;
import com.ht.pojo.TActivity;
import com.ht.service.ActivityService;

public class ActivityServiceimpl implements ActivityService{

	private ActivityDAO activityDAO;
	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	@Override
	public TActivity queryById(String id) {
		return activityDAO.queryById(id);
	}

	@Override
	public void update(TActivity t) {
		activityDAO.update(t);
		
	}

	@Override
	public void add(TActivity t) {
		activityDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return activityDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TActivity t) {
		activityDAO.delete(t);
		
	}

	@Override
	public List<TActivity> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return activityDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TActivity> findactivity(String column, String ifvalue) {
		return activityDAO.findactivity(column, ifvalue);
	}

}
