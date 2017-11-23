package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.MessageDAO;
import com.ht.pojo.TMessage;
import com.ht.service.MessageService;

public class MessageServiceimpl implements MessageService{

	private MessageDAO messageDAO;
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	
	public TMessage queryById(String id) {
		return messageDAO.queryById(id);
	}

	
	public void update(TMessage t) {
		messageDAO.update(t);
		
	}

	
	public void add(TMessage t) {
		messageDAO.add(t);
		
	}

	
	public int count(String column, String ifvalue) {
		return messageDAO.count(column, ifvalue);
	}

	
	public void delete(TMessage t) {
		messageDAO.delete(t);
		
	}

	
	public List<TMessage> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return messageDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TMessage> findmessage(String column, String ifvlue) {
		return messageDAO.findmessage(column, ifvlue);
	}
}
