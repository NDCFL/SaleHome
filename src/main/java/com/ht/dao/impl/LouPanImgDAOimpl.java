package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.LouPanImgDAO;
import com.ht.pojo.TBuildingsImg;

public class LouPanImgDAOimpl implements LouPanImgDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public TBuildingsImg queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TBuildingsImg.class, id);
	}

	
	public void update(TBuildingsImg t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

	
	public void add(TBuildingsImg t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	
	public int count(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildingsImg.class);
		dc.add(Restrictions.eq(column, ifvalue));
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	
	public void delete(TBuildingsImg t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	
	public List<TBuildingsImg> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildingsImg> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	
	public List<TBuildingsImg> loupanimglist() {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildingsImg.class);
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

	
	public List<TBuildingsImg> findloupanimg(String idString) {
		// TODO Auto-generated method stub
		return null;
	}

}
