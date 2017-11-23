package com.ht.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.TAgencyDAO;
import com.ht.pojo.TAgency;
import com.ht.pojo.TBuildings;

public class TAgencyDAOimpl implements TAgencyDAO{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public TAgency queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TAgency.class, id);
	}

	
	public void update(TAgency t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TAgency t set t.statusInt ="+t.getStatusInt()+",t.checkedStatusInt="+t.getCheckedStatusInt()+",t.pwdString='"+t.getPwdString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	
	public void add(TAgency t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	
	public int count(String column, String ifvalue) {
		int cnt = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
			dc.setProjection(Projections.rowCount());
			Criteria criteria = dc.getExecutableCriteria(session);
			cnt = Integer.parseInt(criteria.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	
	public void delete(TAgency t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
		
	}

	
	public List<TAgency> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TAgency> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	
	public List<TAgency> tagencylist(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
		dc.add(Restrictions.eq(column, ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TAgency> list = criteria.list();
		return list;
	}

	@Override
	public void changestatus(String column, String ifvalue,String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TAgency t set "+column+"="+ifvalue+"  where t.idString ='"+id+"'");
		query.executeUpdate();
		
	}

	@Override
	public void shenhe(TAgency tAgency) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TAgency t set t.checkedStatusInt='"+tAgency.getCheckedStatusInt()+"',t.reasonString='"+tAgency.getReasonString()+"'  where t.idString ='"+tAgency.getIdString()+"'");
		query.executeUpdate();
		
		
	}

	@Override
	public int likecount(String starttime, String endtime, String name){
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Session session = sessionFactory.getCurrentSession();
			DetachedCriteria dc = DetachedCriteria.forClass(TAgency.class);
			dc.setProjection(Projections.rowCount());
			if(starttime!=null && !starttime.equals("")){
				System.out.println(starttime+";"+endtime);
				dc.add(Restrictions.between("createdTime", df.parse(starttime), df.parse(endtime)));
			}
			if(name!=null && !name.equals("")){
				dc.add(Restrictions.like("nameString", name,MatchMode.ANYWHERE));
			}
			Criteria criteria = dc.getExecutableCriteria(session);
			System.out.println(Integer.parseInt(criteria.uniqueResult().toString()));
			return Integer.parseInt(criteria.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void updatelogo(TAgency t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TAgency t set t.logoString='"+t.getLogoString()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
		
	}

	@Override
	public void updatetagency(TAgency t) {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);
	}

}
