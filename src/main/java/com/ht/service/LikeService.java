package com.ht.service;

import java.util.List;

import com.ht.pojo.TLike;

public interface LikeService extends BaseService<String, TLike>{

	public abstract List<TLike> likelist(String column,String ifvalue);
	public abstract List<TLike> baobiao();
}
