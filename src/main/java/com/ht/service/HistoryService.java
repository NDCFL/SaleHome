package com.ht.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.pojo.THistory;

public interface HistoryService extends BaseService<String, THistory>{

	public abstract List<THistory> historylist();
	public abstract int pagecount(DetachedCriteria dc);

}
