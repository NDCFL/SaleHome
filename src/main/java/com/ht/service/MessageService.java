package com.ht.service;

import java.util.List;

import com.ht.pojo.TMessage;

public interface MessageService extends BaseService<String, TMessage>{

	public abstract List<TMessage> findmessage(String column,String ifvalue);
}
