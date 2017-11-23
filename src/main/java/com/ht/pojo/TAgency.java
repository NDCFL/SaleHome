package com.ht.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TAgency entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAgency implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String nameString;
	private String emailString;
	private String pwdString;
	private String leaderString;
	private String phoneString;
	private String telString;
	private String addressString;
	private String logoString;
	private String introString;
	private Date createdTime;
	private Integer checkedStatusInt;
	private Integer statusInt;
	private String reasonString;
	private String useridString;
	public String getUseridString() {
		return useridString;
	}
	public void setUseridString(String useridString) {
		this.useridString = useridString;
	}
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	private Set<TBuildings> buildsset = new HashSet<TBuildings>();
	private Set<TBuilding> tbuildset = new HashSet<TBuilding>();
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPwdString() {
		return pwdString;
	}
	public void setPwdString(String pwdString) {
		this.pwdString = pwdString;
	}
	public String getLeaderString() {
		return leaderString;
	}
	public void setLeaderString(String leaderString) {
		this.leaderString = leaderString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getTelString() {
		return telString;
	}
	public void setTelString(String telString) {
		this.telString = telString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public String getLogoString() {
		return logoString;
	}
	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}
	public String getIntroString() {
		return introString;
	}
	public void setIntroString(String introString) {
		this.introString = introString;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getCheckedStatusInt() {
		return checkedStatusInt;
	}
	public void setCheckedStatusInt(Integer checkedStatusInt) {
		this.checkedStatusInt = checkedStatusInt;
	}
	public Integer getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}
	public Set<TBuildings> getBuildsset() {
		return buildsset;
	}
	public void setBuildsset(Set<TBuildings> buildsset) {
		this.buildsset = buildsset;
	}
	public Set<TBuilding> getTbuildset() {
		return tbuildset;
	}
	public void setTbuildset(Set<TBuilding> tbuildset) {
		this.tbuildset = tbuildset;
	}
	
}