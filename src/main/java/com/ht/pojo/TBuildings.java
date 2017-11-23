package com.ht.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TBuildings entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBuildings implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idString;
	private String nameString;
	private String areaString;
	private String addressString;
	private Double floorAreaString;
	private Double buildingAreaString;
	private String houseTypeString;
	private String buildingTypeString;
	private Double longitudeDouble;
	private Double latitudeDouble;
	private Double avgPriceDouble;
	private String companyString;
	private Date openDate;
	private int totalRoomsInt;
	private String receptionAddressString;
	private String telString;
	private Double greenRatioDouble;
	private Double plotRatioDouble;
	private String propertyCompany;
	private Double propertyFeeDouble;
	private Integer carStationInt;
	private String trafficString;
	private String equipmentsString;
	private String logoString;
	private String introString;
	private Date createdTime;
	private int statusInt;
	private String jxsidString;
	private TAgency tagency;
	
	public TAgency getTagency() {
		return tagency;
	}
	public void setTagency(TAgency tagency) {
		this.tagency = tagency;
	}
	public String getJxsidString() {
		return jxsidString;
	}
	public void setJxsidString(String jxsidString) {
		this.jxsidString = jxsidString;
	}
	private Set<TBuilding> buildset = new HashSet<TBuilding>();
	
	public Set<TBuilding> getBuildset() {
		return buildset;
	}
	public void setBuildset(Set<TBuilding> buildset) {
		this.buildset = buildset;
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
	public String getAreaString() {
		return areaString;
	}
	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public Double getFloorAreaString() {
		return floorAreaString;
	}
	public void setFloorAreaString(Double floorAreaString) {
		this.floorAreaString = floorAreaString;
	}
	public Double getBuildingAreaString() {
		return buildingAreaString;
	}
	public void setBuildingAreaString(Double buildingAreaString) {
		this.buildingAreaString = buildingAreaString;
	}
	public String getHouseTypeString() {
		return houseTypeString;
	}
	public void setHouseTypeString(String houseTypeString) {
		this.houseTypeString = houseTypeString;
	}
	public String getBuildingTypeString() {
		return buildingTypeString;
	}
	public void setBuildingTypeString(String buildingTypeString) {
		this.buildingTypeString = buildingTypeString;
	}
	public Double getLongitudeDouble() {
		return longitudeDouble;
	}
	public void setLongitudeDouble(Double longitudeDouble) {
		this.longitudeDouble = longitudeDouble;
	}
	public Double getLatitudeDouble() {
		return latitudeDouble;
	}
	public void setLatitudeDouble(Double latitudeDouble) {
		this.latitudeDouble = latitudeDouble;
	}
	public Double getAvgPriceDouble() {
		return avgPriceDouble;
	}
	public void setAvgPriceDouble(Double avgPriceDouble) {
		this.avgPriceDouble = avgPriceDouble;
	}
	public String getCompanyString() {
		return companyString;
	}
	public void setCompanyString(String companyString) {
		this.companyString = companyString;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public int getTotalRoomsInt() {
		return totalRoomsInt;
	}
	public void setTotalRoomsInt(int totalRoomsInt) {
		this.totalRoomsInt = totalRoomsInt;
	}
	public String getReceptionAddressString() {
		return receptionAddressString;
	}
	public void setReceptionAddressString(String receptionAddressString) {
		this.receptionAddressString = receptionAddressString;
	}
	public String getTelString() {
		return telString;
	}
	public void setTelString(String telString) {
		this.telString = telString;
	}
	public Double getGreenRatioDouble() {
		return greenRatioDouble;
	}
	public void setGreenRatioDouble(Double greenRatioDouble) {
		this.greenRatioDouble = greenRatioDouble;
	}
	public Double getPlotRatioDouble() {
		return plotRatioDouble;
	}
	public void setPlotRatioDouble(Double plotRatioDouble) {
		this.plotRatioDouble = plotRatioDouble;
	}
	public String getPropertyCompany() {
		return propertyCompany;
	}
	public void setPropertyCompany(String propertyCompany) {
		this.propertyCompany = propertyCompany;
	}
	public Double getPropertyFeeDouble() {
		return propertyFeeDouble;
	}
	public void setPropertyFeeDouble(Double propertyFeeDouble) {
		this.propertyFeeDouble = propertyFeeDouble;
	}
	public Integer getCarStationInt() {
		return carStationInt;
	}
	public void setCarStationInt(Integer carStationInt) {
		this.carStationInt = carStationInt;
	}
	public String getTrafficString() {
		return trafficString;
	}
	public void setTrafficString(String trafficString) {
		this.trafficString = trafficString;
	}
	public String getEquipmentsString() {
		return equipmentsString;
	}
	public void setEquipmentsString(String equipmentsString) {
		this.equipmentsString = equipmentsString;
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
	public int getStatusInt() {
		return statusInt;
	}
	public void setStatusInt(int statusInt) {
		this.statusInt = statusInt;
	}
	
}