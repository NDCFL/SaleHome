package com.ht.pojo;

import java.util.Date;

/**
 * TEmployeesalary entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TEmployeesalary implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String salaryIdString;
	private String emoloyeeIdString;
	private String userIdString;
	private Double salaryDouble;
	private String reason;
	private Date createTime;

	public String getSalaryIdString() {
		return salaryIdString;
	}
	public void setSalaryIdString(String salaryIdString) {
		this.salaryIdString = salaryIdString;
	}
	public String getEmoloyeeIdString() {
		return emoloyeeIdString;
	}
	public void setEmoloyeeIdString(String emoloyeeIdString) {
		this.emoloyeeIdString = emoloyeeIdString;
	}
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public Double getSalaryDouble() {
		return salaryDouble;
	}
	public void setSalaryDouble(Double salaryDouble) {
		this.salaryDouble = salaryDouble;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}