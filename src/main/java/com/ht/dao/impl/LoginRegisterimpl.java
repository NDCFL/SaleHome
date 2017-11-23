package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.common.bean.Pager4EasyUI;
import com.ht.dao.LoginRegisterDAO;
import com.ht.pojo.TAgency;
import com.ht.pojo.THouse;
import com.ht.pojo.TUser;

public class LoginRegisterimpl implements LoginRegisterDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public TUser queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TUser.class, id);
	}


	
	public void update(TUser t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	
	public void add(TUser t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}


	
	public int count(String column,String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	
	public List<TUser> findaccount(String phone) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		dc.add(Restrictions.eq("phoneString",phone));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TUser> list = criteria.list();
		return list;
	}

	
	public void delete(TUser t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	
	public List<TUser> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TUser> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

}
