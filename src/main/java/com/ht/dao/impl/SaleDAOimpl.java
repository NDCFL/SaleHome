package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.SaleDAO;
import com.ht.pojo.TBuilding;
import com.ht.pojo.TBuildings;
import com.ht.pojo.THouse;
import com.ht.pojo.TSale;

public class SaleDAOimpl implements SaleDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TSale queryById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TSale.class, id);
	}

	@Override
	public void update(TSale t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TSale t set t.statusInt ="+t.getStatusInt()+"  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	@Override
	public void add(TSale t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TSale.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TSale t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<TSale> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TSale> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<TSale> findsale(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TSale.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TSale> list = criteria.list();
		return list;
	}

	@Override
	public void shenhe(TSale t) {
		Session session = sessionFactory.getCurrentSession();
		Query<TBuildings> query = session.createQuery("update TSale t set t.saleHomeStatus ="+t.getSaleHomeStatus()+",t.reason ='"+t.getReason()+"'  where t.idString ='"+t.getIdString()+"'");
		query.executeUpdate();
	}

	@Override
	public int count() {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TSale.class);
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list().size();
	}

	@Override
	public List<TSale> baobiaolist() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select t.nameString,";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=1 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=2 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=3 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=4 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=5 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=6 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=7 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=8 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=9 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=10 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=11 and h.empIdString=t.idString),";
		sql+="(select count(h.customerIdString) from TSale h where month(h.createdTime)=12 and h.empIdString=t.idString)";
		sql+="from TSale h,TEmployee t where h.empIdString=t.idString and h.saleHomeStatus=1  group BY h.empIdString";
		Query<TSale> query = session.createQuery(sql);
		return query.list();
	}

}
