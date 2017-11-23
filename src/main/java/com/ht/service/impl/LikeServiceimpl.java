package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.LikeDAO;
import com.ht.pojo.TLike;
import com.ht.service.LikeService;

public class LikeServiceimpl implements LikeService{

	private LikeDAO likeDAO;
	public LikeDAO getLikeDAO() {
		return likeDAO;
	}

	public void setLikeDAO(LikeDAO likeDAO) {
		this.likeDAO = likeDAO;
	}

	@Override
	public TLike queryById(String id) {
		return null;
	}

	@Override
	public void update(TLike t) {
		
		likeDAO.update(t);
		
	}

	@Override
	public void add(TLike t) {
		likeDAO.add(t);
		
	}

	@Override
	public int count(String column, String ifvalue) {
		return likeDAO.count(column, ifvalue);
	}

	@Override
	public void delete(TLike t) {
		likeDAO.delete(t);
		
	}

	@Override
	public List<TLike> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return likeDAO.pagelist(dc, startpage, pagesize);
	}

	@Override
	public List<TLike> likelist(String column, String ifvalue) {
		return likeDAO.likelist(column, ifvalue);
	}

	@Override
	public List<TLike> baobiao() {
		return likeDAO.baobiao();
	}

}
