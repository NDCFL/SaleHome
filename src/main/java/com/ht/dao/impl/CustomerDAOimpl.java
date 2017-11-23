package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.CustomerDAO;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TCustomer;
import com.ht.pojo.TUser;

public class CustomerDAOimpl implements CustomerDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TCustomer queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TCustomer.class, id);
	}

	@Override
	public void update(TCustomer t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TUser> query = session.createQuery("update TCustomer t set t.statusInt='"+t.getStatusInt()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	@Override
	public void add(TCustomer t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TCustomer t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<TCustomer> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TCustomer> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<TCustomer> findcustor(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TCustomer.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TCustomer> list = criteria.list();
		return list;

	}

	@Override
	public void buyhouse(TCustomer t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TUser> query = session.createQuery("update TCustomer t set t.customerTypeInt='"+t.getCustomerTypeInt()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}
	
	@Override
	public void upfact(TCustomer t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TCustomer> query = session.createQuery("update TCustomer t set t.contractString ='"+t.getContractString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public List<TCustomer> addcomment(DetachedCriteria dc) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

}
