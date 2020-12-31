package com.digi.unitouch.vo;

public class HolidayVo {
	
	private Integer holidayGroupID;
	private String holidayGroupName = "";
	private Integer holidayID;
	private String holidayName = "";
	private String holidayStartDate;
	private String holidayEndDate;
	
	public Integer getHolidayGroupID() {
		return holidayGroupID;
	}
	public void setHolidayGroupID(Integer holidayGroupID) {
		this.holidayGroupID = holidayGroupID;
	}
	public String getHolidayGroupName() {
		return holidayGroupName;
	}
	public void setHolidayGroupName(String holidayGroupName) {
		this.holidayGroupName = holidayGroupName;
	}
	public Integer getHolidayID() {
		return holidayID;
	}
	public void setHolidayID(Integer holidayID) {
		this.holidayID = holidayID;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public String getHolidayStartDate() {
		return holidayStartDate;
	}
	public void setHolidayStartDate(String holidayStartDate) {
		this.holidayStartDate = holidayStartDate;
	}
	public String getHolidayEndDate() {
		return holidayEndDate;
	}
	public void setHolidayEndDate(String holidayEndDate) {
		this.holidayEndDate = holidayEndDate;
	}
	@Override
	public String toString() {
		return "HolidayVo [holidayGroupID=" + holidayGroupID + ", holidayGroupName=" + holidayGroupName + ", holidayID="
				+ holidayID + ", holidayName=" + holidayName + ", holidayStartDate=" + holidayStartDate
				+ ", holidayEndDate=" + holidayEndDate + "]";
	}
	
}
