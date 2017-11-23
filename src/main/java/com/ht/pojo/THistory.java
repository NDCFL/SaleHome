package com.ht.pojo;

import java.util.Date;

/**
 * THistory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class THistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String userIdString;
	private String buildingsIdString;
	private Date createdTime;
	private String ipString;
	private TBuildings buildings;
	private TUser user;
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
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
	public String getIpString() {
		return ipString;
	}
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	public TBuildings getBuildings() {
		return buildings;
	}
	public void setBuildings(TBuildings buildings) {
		this.buildings = buildings;
	}
	
}