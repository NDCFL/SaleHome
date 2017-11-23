package com.ht.pojo;

/**
 * TMission entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TMission implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private Integer quantityInt;
	private Integer monthesint;
	private String empIdString;
	private int lastQuantityInt;
	public int getLastQuantityInt() {
		return lastQuantityInt;
	}
	public void setLastQuantityInt(int lastQuantityInt) {
		this.lastQuantityInt = lastQuantityInt;
	}
	public TEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(TEmployee employee) {
		this.employee = employee;
	}
	private Double bonusPercentDouble;
	private String jxsidString;
	private TEmployee employee;
	
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public Integer getQuantityInt() {
		return quantityInt;
	}
	public void setQuantityInt(Integer quantityInt) {
		this.quantityInt = quantityInt;
	}
	public Integer getMonthesint() {
		return monthesint;
	}
	public void setMonthesint(Integer monthesint) {
		this.monthesint = monthesint;
	}
	public String getEmpIdString() {
		return empIdString;
	}
	public void setEmpIdString(String empIdString) {
		this.empIdString = empIdString;
	}
	public Double getBonusPercentDouble() {
		return bonusPercentDouble;
	}
	public void setBonusPercentDouble(Double bonusPercentDouble) {
		this.bonusPercentDouble = bonusPercentDouble;
	}

}