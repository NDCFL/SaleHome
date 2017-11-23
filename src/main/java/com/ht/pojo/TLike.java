package com.ht.pojo;

import java.util.Date;

/**
 * TLike entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TLike implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String idString;
	private String userIdString;
	private String buildingsIdString;
	private Date createdTime;
	private TUser user;
	private TBuildings buildings;
	public TBuildings getBuildings() {
		return buildings;
	}
	public void setBuildings(TBuildings buildings) {
		this.buildings = buildings;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public String getBuildingsIdString() {
		return buildingsIdString;
	}
	public void setBuildingsIdString(String buildingsIdString) {
		this.buildingsIdString = buildingsIdString;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	
}