package com.ht.pojo;

import java.util.Date;

/**
 * TAppointment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAppointment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String empIdString;
	private String userIdString;
	private Date appArriveTime;
	private Date arriveTime;
	private String houseIdString;
	private Integer appStatusInt;
	private Date createdTime;
	private Integer status;
	private TEmployee employee;
	private TUser user;
	private THouse house;
	private String reasonString;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getEmpIdString() {
		return empIdString;
	}
	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
	}
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public Date getAppArriveTime() {
		return appArriveTime;
	}
	public void setAppArriveTime(Date appArriveTime) {
		this.appArriveTime = appArriveTime;
	}
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getHouseIdString() {
		return houseIdString;
	}
	public void setHouseIdString(String houseIdString) {
		this.houseIdString = houseIdString;
	}
	public Integer getAppStatusInt() {
		return appStatusInt;
	}
	public void setAppStatusInt(Integer appStatusInt) {
		this.appStatusInt = appStatusInt;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public THouse getHouse() {
		return house;
	}
	public void setHouse(THouse house) {
		this.house = house;
	}
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	private String jxsidString;



	
}