package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.UserDAO;
import com.ht.pojo.TUser;

public class UserDAOimpl implements UserDAO{

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
		Query<TUser> query = session.createQuery("update TUser t set t.usertypeInt='"+t.getUsertypeInt()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	
	public void add(TUser t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
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

	
	public List<TUser> finduser() {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TUser> list = criteria.list();
		return list;
	}
	
	public void updateuserinfo(TUser t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TUser> query = session.createQuery("update TUser t set t.headiconString='"+t.getHeadiconString()+"',t.nameString='"+t.getNameString()+"',t.nicknameString='"+t.getNicknameString()+"',t.emailString='"+t.getEmailString()+"',t.phoneString='"+t.getPhoneString()+"',t.wechatString='"+t.getWechatString()+"',t.qqString='"+t.getQqString()+"',t.genderString='"+t.getGenderString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}
	public void updateuserpwd(TUser user) {
		Session session = sessionFactory.getCurrentSession();
		Query<TUser> query = session.createQuery("update TUser t set t.pwdString='"+user.getPwdString()+"'  where t.idString ='"+user.getIdString()+"'");
		query.executeUpdate();
		
	}
	@Override
	public List<TUser> finduser(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TUser.class);
		dc.add(Restrictions.eq(column, ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TUser> list = criteria.list();
		return list;
	}

}
