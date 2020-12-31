package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_grp_dept_mapping")
public class HolidayGrpDeptMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hgd_id")
	private Integer hgdId;

	@Column(name = "holiday_grp_id")
	private Integer holidayGrpId;
	
	@Column(name = "department_id")
	private Integer departmentId;

	public Integer getHgdId() {
		return hgdId;
	}

	public void setHgdId(Integer hgdId) {
		this.hgdId = hgdId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getHolidayGrpId() {
		return holidayGrpId;
	}

	public void setHolidayGrpId(Integer holidayGrpId) {
		this.holidayGrpId = holidayGrpId;
	}

	@Override
	public String toString() {
		return "HolidayGrpDeptMapping [hgdId=" + hgdId + ", holidayGrpId=" + holidayGrpId + ", departmentId="
				+ departmentId + "]";
	}
	
}
