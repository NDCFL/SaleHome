package com.ht.pojo;

import java.util.Date;

/**
 * TUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String emailString;
	private String phoneString;
	private String pwdString;
	private String qqString;
	private String wechatString;
	private String genderString;
	private Date birthday;
	private String nicknameString;
	private String nameString;
	private String headiconString;
	private int statusInt;
	private String reasonString;
	private int usertypeInt;
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public String getPwdString() {
		return pwdString;
	}
	public void setPwdString(String pwdString) {
		this.pwdString = pwdString;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNicknameString() {
		return nicknameString;
	}
	public void setNicknameString(String nicknameString) {
		this.nicknameString = nicknameString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getHeadiconString() {
		return headiconString;
	}
	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
	}
	public int getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(int statusInt) {
		this.statusInt = statusInt;
	}
	public String getReasonString() {
		return reasonString;
	}
	public void setReasonString(String reasonString) {
		this.reasonString = reasonString;
	}
	public int getUsertypeInt() {
		return usertypeInt;
	}
	public void setUsertypeInt(int usertypeInt) {
		this.usertypeInt = usertypeInt;
	}
}