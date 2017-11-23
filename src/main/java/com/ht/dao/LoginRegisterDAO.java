package com.ht.dao;

import java.util.List;

import com.ht.pojo.TUser;

public interface LoginRegisterDAO extends BaseDAO<String, TUser>{

	public abstract List<TUser>  findaccount(String phone);
}
