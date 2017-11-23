package com.ht.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.AppointmentDAO;
import com.ht.pojo.TAppointment;

public class AppointmentDAOimpl implements AppointmentDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TAppointment queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TAppointment.class, id);
	}

	public void update(TAppointment t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TAppointment> query = null;
		if(t.getArriveTime()==null){
			query= session.createQuery("update TAppointment t set t.appStatusInt ='"+t.getAppStatusInt()+"',t.reasonString='"+t.getReasonString()+"'  where t.idString ='"+t.getIdString()+"'");
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String d= df.format(t.getArriveTime());
			query= session.createQuery("update TAppointment t set t.arriveTime ='"+d+"',t.appStatusInt ='"+t.getAppStatusInt()+"',t.reasonString='"+t.getReasonString()+"'  where t.idString ='"+t.getIdString()+"'");
		}
		query.executeUpdate();
	}

	@Override
	public void add(TAppointment t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TAppointment t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<TAppointment> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		@SuppressWarnings("unchecked")
		List<TAppointment> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TAppointment> appointmentlist(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

	@Override
	public void updatestatus(TAppointment t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TAppointment> query = session.createQuery("update TAppointment t set t.appStatusInt ='"+t.getAppStatusInt()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updateuserstatus(TAppointment t) {
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String d= df.format(t.getArriveTime());
		Query<TAppointment> query= session.createQuery("update TAppointment t set t.arriveTime ='"+d+"',t.reasonString='"+t.getReasonString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	@Override
	public int buyhousecount(String userid, int appstatus) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TAppointment.class);
		dc.add(Restrictions.eq("userIdString",userid));
		dc.add(Restrictions.eq("appStatusInt",appstatus));
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list().size();
	}

}
