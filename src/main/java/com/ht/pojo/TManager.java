package com.ht.pojo;

import java.util.Date;

/**
 * TManager entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TManager implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String phoneString;
	private String passwordString;
	private String nameString;
	private Integer sexInt;
	private Integer statusInt;
	private Integer typeInt;
	private Date createTime;
	private String reasonString;
	private String headiconString;
	private int checkedStatusInt;
	public int getCheckedStatusInt() {
		return checkedStatusInt;
	}
	public void setCheckedStatusInt(int checkedStatusInt) {
		this.checkedStatusInt = checkedStatusInt;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Integer getSexInt() {
		return sexInt;
	}
	public void setSexInt(Integer sexInt) {
		this.sexInt = sexInt;
	}
	public Integer getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}
	public Integer getTypeInt() {
		return typeInt;
	}
	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	public String getHeadiconString() {
		return headiconString;
	}
	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
	}

	
}