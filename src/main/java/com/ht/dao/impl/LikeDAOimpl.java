package com.ht.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ht.dao.LikeDAO;
import com.ht.pojo.TLike;

public class LikeDAOimpl implements LikeDAO{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TLike queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TLike t) {

	}

	@Override
	public void add(TLike t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TLike.class);
		dc.setProjection(Projections.rowCount());
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	@Override
	public void delete(TLike t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public List<TLike> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		List<TLike> list = criteria.setFirstResult(startpage).setMaxResults(pagesize).list();
		return list;
	}

	@Override
	public List<TLike> likelist(String column, String ifvalue) {
		Session session = sessionFactory.getCurrentSession();
		DetachedCriteria dc = DetachedCriteria.forClass(TLike.class);
		dc.add(Restrictions.eq(column,ifvalue));
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

	@Override
	public List<TLike> baobiao() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select b.nameString,"; 
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=1 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=2 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=3 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=4 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=5 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=6 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=7 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=8 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=9 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=10 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=11 and t.buildingsIdString=b.idString),";
		sql+="(select count(t.userIdString) from TLike t where month(t.createdTime)=12 and t.buildingsIdString=b.idString)";
		sql+="from TLike t,TBuildings b where t.buildingsIdString=b.idString  group by t.buildingsIdString ";
		Query<TLike> query = session.createQuery(sql);
		return query.list();
	}

}
