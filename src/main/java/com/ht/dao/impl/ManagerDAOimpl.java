package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.ManagerDAO;
import com.ht.pojo.TBuildings;
import com.ht.pojo.TManager;

public class ManagerDAOimpl implements ManagerDAO{

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	@Override
	public TManager queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TManager.class, id);
	}

	@Override
	public void update(TManager t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TManager t set t.checkedStatusInt ="+t.getCheckedStatusInt()+",t.typeInt ="+t.getTypeInt()+",t.reasonString ='"+t.getReasonString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	@Override
	public void add(TManager t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TManager.class);
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TManager t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<TManager> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TManager> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<TManager> managerList(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TManager.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TManager> list = criteria.list();
		return list;
	}

	@Override
	public List<TManager> findManager(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TManager.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TManager> list = criteria.list();
		return list;
	}

	@Override
	public void updateManager(TManager manager) {
		Session session = sessionFactory.getCurrentSession();
		Query<TManager> query = session.createQuery("update TManager t set t.headiconString ='"+manager.getHeadiconString()+"',t.nameString ='"+manager.getNameString()+"',t.sexInt ='"+manager.getSexInt()+"'  where t.idString ='"+manager.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updatepwd(TManager manager) {
		Session session = sessionFactory.getCurrentSession();
		Query<TManager> query = session.createQuery("update TManager t set t.passwordString ='"+manager.getPasswordString()+"'  where t.idString ='"+manager.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updatestatus(TManager manager) {
		Session session = sessionFactory.getCurrentSession();
		Query<TManager> query = session.createQuery("update TManager t set t.statusInt ='"+manager.getStatusInt()+"'  where t.idString ='"+manager.getIdString()+"'");
		query.executeUpdate();
		
	}

}
