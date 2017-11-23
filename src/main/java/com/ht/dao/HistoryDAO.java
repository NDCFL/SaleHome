package com.ht.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.THistory;

public interface HistoryDAO extends BaseDAO<String, THistory>{

	public abstract List<THistory> historylist();
	public abstract int pagecount(DetachedCriteria dc);
}
