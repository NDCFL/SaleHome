package com.ht.dao;

import java.util.List;

import com.ht.pojo.TBuilding;
import com.ht.pojo.THouse;
import com.ht.pojo.TRoom;

public interface RoomDAO extends BaseDAO<String, TRoom>{

	public abstract List<TRoom>  findroomlist(String column,String ifvalue);
	public abstract List<TBuilding> findloudong(String column,String ifvalue);
	public abstract List<THouse> findhuxing(String column,String ifvalue);
	public abstract List<TRoom> roomlist();
}
