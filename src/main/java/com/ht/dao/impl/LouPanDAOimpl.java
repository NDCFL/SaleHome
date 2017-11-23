package com.ht.dao.impl;

import java.util.List;

import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.LouPanDAO;
import com.ht.pojo.TBuildings;

public class LouPanDAOimpl implements LouPanDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public TBuildings queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TBuildings.class, id);
	}


	
	public void update(TBuildings t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TBuildings t set t.statusInt ="+t.getStatusInt()+"  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}
	
	public void add(TBuildings t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}
	
	public int count(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	
	public List<TBuildings> buildingslist(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildings> list = criteria.list();
		return list;
	}

	
	public void delete(TBuildings t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	
	public List<TBuildings> findloupan(String idString) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.add(Restrictions.eq("idString",idString));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildings> list = criteria.list();
		return list;
	}

	
	public List<TBuildings> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildings> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public int count() {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public List<TBuildings> likebuildings(String column, String ifvalue,int startpage,int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("from TBuildings t where "+column+" like:ifvalue");
		query.setString("ifvalue", ifvalue);
		List<TBuildings> list = query.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public int likecount(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("from TBuildings t where "+column+" like:ifvalue");
		query.setString("ifvalue", ifvalue);
		return query.list().size();
	}

	@Override
	public List<TBuildings> likebuildings(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("from TBuildings t where "+column+" like:ifvalue or t.nameString like:value");
		query.setString("ifvalue", ifvalue);
		query.setString("value", ifvalue);
		List<TBuildings> list = query.list();
		return list;
	}

	@Override
	public List<TBuildings> baobiao() {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("select t.avgPriceDouble,t.nameString,MONTH(t.openDate) from TBuildings t where  t.statusInt=0   group BY t.idString,MONTH(t.openDate) ");
		return query.list();
	}

	@Override
	public List<TBuildings> loupanlist() {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TBuildings.class);
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TBuildings> list = criteria.list();
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
