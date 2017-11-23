package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.UserPrizeDAO;
import com.ht.pojo.TUserprize;

public class UserPrizeDAOimpl implements UserPrizeDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public TUserprize queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TUserprize.class, id);
	}

	
	public void update(TUserprize t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	
	public void add(TUserprize t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUserprize.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	
	public void delete(TUserprize t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
		
	}

	
	public List<TUserprize> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TUserprize> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	
	public List<TUserprize> finduserprize(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUserprize.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

	
	public double salary(String employeeid) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUserprize.class);
		dc.add(Restrictions.eq("employeeidString", employeeid));
		dc.setProjection(Projections.sum("prize"));
		Criteria criteria = dc.getExecutableCriteria(session);
		double money = 0.0;
		try {
			money =Double.parseDouble(criteria.list().get(0).toString());
		} catch (Exception e) {
			money=0.0;
		}
		return money;
	}

	
}
