package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.ArticleDAO;
import com.ht.pojo.TArticle;
import com.ht.service.ArticleService;

public class ArticleServiceimpl implements ArticleService{

	private ArticleDAO articleDAO;
	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public TArticle queryById(String id) {
		return articleDAO.queryById(id);
	}

	@Override
	public void update(TArticle t) {
		articleDAO.update(t);
		
	}

	@Override
	public void add(TArticle t) {
		articleDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return articleDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TArticle t) {
		articleDAO.delete(t);
		
	}

	@Override
	public List<TArticle> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return articleDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TArticle> findwzlist(String colomn, String ifvalue) {
		return articleDAO.findwzlist(colomn, ifvalue);
	}

	@Override
	public int articlesize() {
		return articleDAO.articlesize();
	}

	@Override
	public void updatearticlestatus(TArticle t) {
		articleDAO.updatearticlestatus(t);
		
	}

	@Override
	public List<TArticle> facetaricle() {
		return articleDAO.facetaricle();
	}

}
