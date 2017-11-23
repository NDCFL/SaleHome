package com.ht.service;

import java.util.List;

import com.ht.pojo.TBuildingsImg;

public interface LouPanImgService extends BaseService<String, TBuildingsImg>{
	public abstract List<TBuildingsImg> loupanimglist();
	public abstract List<TBuildingsImg> findloupanimg(String idString);
}
