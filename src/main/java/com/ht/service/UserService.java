package com.ht.service;

import java.util.List;

import com.ht.pojo.TUser;

public interface UserService extends BaseService<String, TUser>{

	public abstract List<TUser> finduser();
	public abstract void updateuserinfo(TUser t);
	public abstract void updateuserpwd(TUser user);
	public abstract List<TUser> finduser(String column,String ifvalue);
}
