package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_group")
public class HolidayGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "holiday_grp_id")
	private Integer holidayGrpId;
	
	@Column(name = "holiday_grp_name")
	private String holidayGrpName;

	public Integer getHolidayGrpId() {
		return holidayGrpId;
	}

	public void setHolidayGrpId(Integer holidayGrpId) {
		this.holidayGrpId = holidayGrpId;
	}

	public String getHolidayGrpName() {
		return holidayGrpName;
	}

	public void setHolidayGrpName(String holidayGrpName) {
		this.holidayGrpName = holidayGrpName;
	}

	@Override
	public String toString() {
		return "HolidayGroup [holidayGrpId=" + holidayGrpId + ", holidayGrpName=" + holidayGrpName + "]";
	}
	
}
