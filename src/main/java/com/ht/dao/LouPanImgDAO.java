package com.ht.dao;

import java.util.List;

import com.ht.pojo.TBuildingsImg;

public interface LouPanImgDAO extends BaseDAO<String, TBuildingsImg>{

	public abstract List<TBuildingsImg> loupanimglist();
	public abstract List<TBuildingsImg> findloupanimg(String idString);
}
