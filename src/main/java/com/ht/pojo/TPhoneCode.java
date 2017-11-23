package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

public class TPhoneCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String phoneString;
	private int phoneCode;
	private Date sendTime;
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
	public int getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
}
