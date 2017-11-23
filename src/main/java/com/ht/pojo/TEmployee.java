package com.ht.pojo;

import java.util.Date;

import org.omg.CORBA.ORBPackage.InconsistentTypeCode;

/**
 * TEmployee entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TEmployee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String nameString;
	private String emailString;
	private String pwdString;
	private String phoneString;
	private String qqString;
	private String wechatString;
	private String genderString;
	private String expString;
	private String desString;
	private String addressString;
	private Double basicSalaryDouble;
	private String headiconString;
	private String introString;
	private String angencyIdString;
	private String buildingIdString;
	private Date createdTime;
	private Integer statusInt;
	private int typeInt;
	private TAgency tagency;
	private TBuildings loupan;
	public TAgency getTagency() {
		return tagency;
	}
	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public TBuildings getLoupan() {
		return loupan;
	}
	public void setLoupan(TBuildings loupan) {
		this.loupan = loupan;
	}
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
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getQqString() {
		return qqString;
	}
	public void setQqString(String qqString) {
		this.qqString = qqString;
	}
	public String getWechatString() {
		return wechatString;
	}
	public void setWechatString(String wechatString) {
		this.wechatString = wechatString;
	}
	public String getGenderString() {
		return genderString;
	}
	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}
	public String getExpString() {
		return expString;
	}
	public void setExpString(String expString) {
		this.expString = expString;
	}
	public String getDesString() {
		return desString;
	}
	public void setDesString(String desString) {
		this.desString = desString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public Double getBasicSalaryDouble() {
		return basicSalaryDouble;
	}
	public void setBasicSalaryDouble(Double basicSalaryDouble) {
		this.basicSalaryDouble = basicSalaryDouble;
	}
	public String getHeadiconString() {
		return headiconString;
	}
	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
	}
	public String getIntroString() {
		return introString;
	}
	public void setIntroString(String introString) {
		this.introString = introString;
	}
	public String getAngencyIdString() {
		return angencyIdString;
	}
	public void setAngencyIdString(String angencyIdString) {
		this.angencyIdString = angencyIdString;
	}
	public String getBuildingIdString() {
		return buildingIdString;
	}
	public void setBuildingIdString(String buildingIdString) {
		this.buildingIdString = buildingIdString;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(Integer statusInt) {
		this.statusInt = statusInt;
	}
	public int getTypeInt() {
		return typeInt;
	}
	public void setTypeInt(int typeInt) {
		this.typeInt = typeInt;
	}

}