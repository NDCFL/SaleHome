package com.ht.service;

import java.util.List;

import com.ht.pojo.TPage;

public interface PageService extends BaseService<String, TPage>{

	public abstract List<TPage> findpage(String column,String ifvalue);
}
