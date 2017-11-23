package com.ht.dao;

import java.util.List;

import com.ht.pojo.TArticle;

public interface ArticleDAO extends BaseDAO<String, TArticle>{

	public abstract List<TArticle> findwzlist(String colomn,String ifvalue);
	public abstract int articlesize();
	public abstract void updatearticlestatus(TArticle t);
	public abstract List<TArticle> facetaricle();
}
