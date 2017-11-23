package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.HistoryDAO;
import com.ht.pojo.TBaobiao;
import com.ht.pojo.THistory;
import com.ht.pojo.THouse;

public class HistoryDAOimpl implements HistoryDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public THistory queryById(String id) {
		return null;
	}

	@Override
	public void update(THistory t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(THistory t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(THistory.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(THistory t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<THistory> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<THistory> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<THistory> historylist() {
		Session session = sessionFactory.getCurrentSession();
		String sql="select t.nameString,";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=1 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=2 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=3 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=4 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=5 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=6 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=7 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=8 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=9 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=10 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=11 and h.buildingsIdString=t.idString),";
		sql+="(select count(h.userIdString) from THistory h where month(h.createdTime)=12 and h.buildingsIdString=t.idString)";
		sql+="from THistory h,TBuildings t where h.buildingsIdString=t.idString group BY h.buildingsIdString";
		Query query = session.createQuery(sql);
		return query.list();
	}

	@Override
	public int pagecount(DetachedCriteria dc) {
		Session session = sessionFactory.getCurrentSession();
		dc.setProjection(Projections.rowCount());
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

}
