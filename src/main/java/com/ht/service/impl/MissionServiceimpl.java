package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.MissionDAO;
import com.ht.pojo.TMission;
import com.ht.service.MissionService;

public class MissionServiceimpl implements MissionService{

	public MissionDAO getMissionDAO() {
		return missionDAO;
	}

	public void setMissionDAO(MissionDAO missionDAO) {
		this.missionDAO = missionDAO;
	}

	private MissionDAO missionDAO;

	@Override
	public TMission queryById(String id) {
		return missionDAO.queryById(id);
	}

	@Override
	public void update(TMission t) {
		missionDAO.update(t);
		
	}

	@Override
	public void add(TMission t) {
		missionDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return missionDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TMission t) {
		missionDAO.delete(t);
		
	}

	@Override
	public List<TMission> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return missionDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TMission> findmission(String column, String ifvalue) {
		return missionDAO.findmission(column, ifvalue);
	}

	@Override
	public void updatelastquentity(TMission t) {
		missionDAO.updatelastquentity(t);
		
	}
}
