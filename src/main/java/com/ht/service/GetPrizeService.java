package com.ht.service;

import java.util.List;

import com.ht.pojo.TGetPrize;

public interface GetPrizeService extends BaseService<String, TGetPrize> {

	public abstract List<TGetPrize> findlist(String column,String ifvalue);

}
