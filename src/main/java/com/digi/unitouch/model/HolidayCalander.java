package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "holiday_calander")
public class HolidayCalander {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hc_id")
	private Integer hcId;

	@Column(name = "hg_id")
	private Integer hgId;
	
	@Column(name = "holiday_name")
	private String holidayName;
	
	@OneToOne(optional = false)
	@JoinColumn(name="hg_id",insertable = false,updatable = false)
	private HolidayGroup holidayGroup;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "holiday_startdate")
	private Date holidayStartDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "holiday_enddate")
	private Date holidayEndDate;

	public Integer getHcId() {
		return hcId;
	}

	public void setHcId(Integer hcId) {
		this.hcId = hcId;
	}

	public Integer getHgId() {
		return hgId;
	}

	public void setHgId(Integer hgId) {
		this.hgId = hgId;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public HolidayGroup getHolidayGroup() {
		return holidayGroup;
	}

	public void setHolidayGroup(HolidayGroup holidayGroup) {
		this.holidayGroup = holidayGroup;
	}

	public Date getHolidayStartDate() {
		return holidayStartDate;
	}

	public void setHolidayStartDate(Date holidayStartDate) {
		this.holidayStartDate = holidayStartDate;
	}

	public Date getHolidayEndDate() {
		return holidayEndDate;
	}

	public void setHolidayEndDate(Date holidayEndDate) {
		this.holidayEndDate = holidayEndDate;
	}

	@Override
	public String toString() {
		return "HolidayCalander [hcId=" + hcId + ", hgId=" + hgId + ", holidayName=" + holidayName + ", holidayGroup="
				+ holidayGroup + ", holidayStartDate=" + holidayStartDate + ", holidayEndDate=" + holidayEndDate + "]";
	}

}
