package com.ht.pojo;

import java.util.Date;

/**
 * TBuildingsImg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBuildingsImg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String imgPathString;
	private String imgDesString;
	private String buildingsIdString;
	private Date createdTime;
	private String jxsidString;
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	private TBuildings loupan;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getImgPathString() {
		return imgPathString;
	}
	public void setImgPathString(String imgPathString) {
		this.imgPathString = imgPathString;
	}
	public String getImgDesString() {
		return imgDesString;
	}
	public void setImgDesString(String imgDesString) {
		this.imgDesString = imgDesString;
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
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
	
}