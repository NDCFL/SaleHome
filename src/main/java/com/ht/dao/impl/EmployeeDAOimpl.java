package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.EmployeeDAO;
import com.ht.pojo.TEmployee;

public class EmployeeDAOimpl implements EmployeeDAO{

	private SessionFactory sessionFactory;

	@Override
	public TEmployee queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TEmployee.class, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void update(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TEmployee> query = session.createQuery("update TEmployee t set t.pwdString ='"+t.getPwdString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void add(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TEmployee.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
		
	}

	@Override
	public List<TEmployee> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TEmployee> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<TEmployee> empList(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TEmployee.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TEmployee> list = criteria.list();
		return list;
	}

	@Override
	public void updateinfo(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TEmployee> query = session.createQuery("update TEmployee t set t.nameString ='"+t.getNameString()+"',t.emailString ='"+t.getEmailString()+"',t.phoneString ="+t.getPhoneString()+",t.qqString ='"+t.getQqString()+"',t.wechatString ='"+t.getWechatString()+"',t.genderString ='"+t.getGenderString()+"',t.addressString ='"+t.getAddressString()+"',t.introString ='"+t.getIntroString()+"',t.expString ='"+t.getExpString()+"',t.headiconString ='"+t.getHeadiconString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updatestatus(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TEmployee> query = session.createQuery("update TEmployee t set t.statusInt ='"+t.getStatusInt()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updateemployee(TEmployee t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TEmployee> query = session.createQuery("update TEmployee t set t.buildingIdString ='"+t.getBuildingIdString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

}
