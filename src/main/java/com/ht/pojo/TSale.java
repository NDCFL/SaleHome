package com.ht.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TSale entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSale implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String idString;
	private String customerIdString;
	private Date saleTimeString;
	private Double unitPriceDouble;
	private String roomIdString;
	private Double discountDouble;
	private Double totalCostDouble;
	private String empIdString;
	private Date createdTime;
	private Integer statusInt;
	private int saleHomeStatus;
	private String reason;
	public int getSaleHomeStatus() {
		return saleHomeStatus;
	}
	public void setSaleHomeStatus(int saleHomeStatus) {
		this.saleHomeStatus = saleHomeStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private TEmployee employee;
	private TCustomer customer;
	private TRoom room;
	public TRoom getRoom() {
		return room;
	}
	public void setRoom(TRoom room) {
		this.room = room;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getCustomerIdString() {
		return customerIdString;
	}
	public void setCustomerIdString(String customerIdString) {
		this.customerIdString = customerIdString;
	}
	public Date getSaleTimeString() {
		return saleTimeString;
	}
	public void setSaleTimeString(Date saleTimeString) {
		this.saleTimeString = saleTimeString;
	}
	public Double getUnitPriceDouble() {
		return unitPriceDouble;
	}
	public void setUnitPriceDouble(Double unitPriceDouble) {
		this.unitPriceDouble = unitPriceDouble;
	}
	public String getRoomIdString() {
		return roomIdString;
	}
	public void setRoomIdString(String roomIdString) {
		this.roomIdString = roomIdString;
	}
	public Double getDiscountDouble() {
		return discountDouble;
	}
	public void setDiscountDouble(Double discountDouble) {
		this.discountDouble = discountDouble;
	}
	public Double getTotalCostDouble() {
		return totalCostDouble;
	}
	public void setTotalCostDouble(Double totalCostDouble) {
		this.totalCostDouble = totalCostDouble;
	}
	public String getEmpIdString() {
		return empIdString;
	}
	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
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
	

	
}