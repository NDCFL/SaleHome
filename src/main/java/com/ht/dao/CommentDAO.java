package com.ht.dao;

import java.util.List;

import com.ht.pojo.TComment;

public interface CommentDAO extends BaseDAO<String, TComment>{

	public abstract List<TComment> findcomment(String column,String ifvalue);
}
