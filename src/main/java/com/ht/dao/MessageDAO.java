package com.ht.dao;

import java.util.List;

import com.ht.pojo.TMessage;

public interface MessageDAO extends BaseDAO<String, TMessage>{

	public abstract List<TMessage> findmessage(String column,String ifvlue);
}
