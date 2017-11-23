package com.ht.service;

import java.util.List;

import com.ht.pojo.TComment;

public interface CommentService extends BaseService<String, TComment>{

	public abstract List<TComment> findcomment(String column,String ifvalue);

}
