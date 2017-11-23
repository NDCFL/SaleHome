package com.ht.pojo;

import java.util.Date;

/**
 * TUserprize entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUserprize implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String userIdString;
	private Date createTime;
	private double prize;
	private String employeeidString;
	private TEmployee employee;
	private TCustomer customer;
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	
	
	public TCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(TCustomer customer) {
		this.customer = customer;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public String getEmployeeidString() {
		return employeeidString;
	}
	public void setEmployeeidString(String employeeidString) {
		this.employeeidString = employeeidString;
	}

}