package com.ht.dao;

import java.util.List;

import com.ht.pojo.TLike;

public interface LikeDAO extends BaseDAO<String, TLike>{


	public abstract List<TLike> likelist(String column,String ifvalue);
	public abstract List<TLike> baobiao();
}
