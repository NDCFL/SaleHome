package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.PhoneCodeDAO;
import com.ht.pojo.TAppointment;
import com.ht.pojo.TPhoneCode;

public class PhoneCodeDAOimpl implements PhoneCodeDAO{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TPhoneCode queryById(String id) {
		return null;
	}

	@Override
	public void update(TPhoneCode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(TPhoneCode t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(t.idString) from TPhoneCode t where dayofmonth(t.sendTime)=? and t.phoneString=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, Integer.parseInt(column));
		query.setString(1, ifvalue);
		int num =Integer.parseInt(query.list().get(0).toString());  
		System.out.println(num+"------------");
		return num;
	}

	@Override
	public void delete(TPhoneCode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TPhoneCode> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

}
