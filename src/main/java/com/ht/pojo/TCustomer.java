package com.ht.pojo;

import java.util.Date;

/**
 * TCustomer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCustomer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String idString;
	private String nameString;
	private String headiconString;
	private String genderString;
	private Date birthday;
	private String identityIdString;
	private String emailString;
	private String phoneString;
	private String addressString;
	private int customerTypeInt;
	private String togetherString;
	private String contractString;
	private String archivesString;
	private Date createdTime;
	private Integer statusInt;
	private String employeeId;
	private TEmployee employee;
	private String jxsidString;
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
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
	public String getHeadiconString() {
		return headiconString;
	}
	public void setHeadiconString(String headiconString) {
		this.headiconString = headiconString;
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
	public String getIdentityIdString() {
		return identityIdString;
	}
	public void setIdentityIdString(String identityIdString) {
		this.identityIdString = identityIdString;
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
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public int getCustomerTypeInt() {
		return customerTypeInt;
	}
	public void setCustomerTypeInt(int customerTypeInt) {
		this.customerTypeInt = customerTypeInt;
	}
	public String getTogetherString() {
		return togetherString;
	}
	public void setTogetherString(String togetherString) {
		this.togetherString = togetherString;
	}
	public String getContractString() {
		return contractString;
	}
	public void setContractString(String contractString) {
		this.contractString = contractString;
	}
	public String getArchivesString() {
		return archivesString;
	}
	public void setArchivesString(String archivesString) {
		this.archivesString = archivesString;
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}