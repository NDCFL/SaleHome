package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.CommentDAO;
import com.ht.pojo.TComment;
import com.ht.service.CommentService;

public class CommentServiceimpl implements CommentService{

	private CommentDAO commentDAO;
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	public TComment queryById(String id) {
		return commentDAO.queryById(id);
	}

	@Override
	public void update(TComment t) {
		commentDAO.update(t);
		
	}

	@Override
	public void add(TComment t) {
		commentDAO.add(t);
	}

	@Override
	public int count(String column, String ifvalue) {
		return commentDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TComment t) {
		commentDAO.delete(t);
		
	}

	@Override
	public List<TComment> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return commentDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TComment> findcomment(String column, String ifvalue) {
		return commentDAO.findcomment(column, ifvalue);
	}

}
