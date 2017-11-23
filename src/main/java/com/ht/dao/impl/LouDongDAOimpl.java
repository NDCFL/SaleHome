package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.LouDongDAO;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;

public class LouDongDAOimpl implements LouDongDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public TBuilding queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TBuilding.class, id);
	}


	
	public void update(TBuilding t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TBuilding t set t.statusInt ="+t.getStatusInt()+"  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	
	public void add(TBuilding t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	
	public int count(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column, ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	
	public void delete(TBuilding t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	
	public List<TBuilding> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuilding> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	
	public List<TBuilding> loudonglist(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
		dc.add(Restrictions.eq(column, ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuilding> list = criteria.list();
		return list;
	}

	
	public List<TBuildings> findloupan(String jsxidString) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq("jxsidString",jsxidString));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildings> list = criteria.list();
		return list;
	}

	
	public List<TBuilding> findloudong(String idString) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuilding.class);
		dc.add(Restrictions.eq("idString",idString));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuilding> list = criteria.list();
		return list;
	}

	@Override
	public int pagecount(DetachedCriteria dc) {
		Session session = sessionFactory.getCurrentSession();
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

}
