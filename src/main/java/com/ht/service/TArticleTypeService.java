package com.ht.service;

import java.util.List;

import com.ht.pojo.TArticleType;

public interface TArticleTypeService extends BaseService<String, TArticleType>{

	public abstract List<TArticleType> findtype();

}
