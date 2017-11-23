package com.ht.service;

import java.util.List;

import com.ht.pojo.TUser;

public interface LoginRegisterService extends BaseService<String, TUser>{

	public abstract List<TUser>  findaccount(String phone);
}
