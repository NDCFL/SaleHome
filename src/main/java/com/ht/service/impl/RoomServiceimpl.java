package com.ht.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ht.dao.RoomDAO;
import com.ht.pojo.TBuilding;
import com.ht.pojo.THouse;
import com.ht.pojo.TRoom;
import com.ht.service.RoomService;

public class RoomServiceimpl implements RoomService{

	private RoomDAO roomDAO;
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}

	
	public TRoom queryById(String id) {
		return roomDAO.queryById(id);
	}

	
	public void update(TRoom t) {
		roomDAO.update(t);
			
	}

	
	public void add(TRoom t) {
		roomDAO.add(t);
		
	}

	
	public int count(String column, String ifvalue) {
		return roomDAO.count(column, ifvalue);
	}

	
	public void delete(TRoom t) {
		roomDAO.delete(t);
		
	}

	
	public List<TRoom> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
		return roomDAO.pagelist(dc, startpage, pagesize);
	}

	
	public List<TRoom> findroomlist(String column, String ifvalue) {
		return roomDAO.findroomlist(column, ifvalue);
	}

	
	public List<TBuilding> findloudong(String column, String ifvalue) {
		return roomDAO.findloudong(column, ifvalue);
	}

	
	public List<THouse> findhuxing(String column, String ifvalue) {
		return roomDAO.findhuxing(column, ifvalue);
	}

	@Override
	public List<TRoom> roomlist() {
		return roomDAO.roomlist();
	}

}
