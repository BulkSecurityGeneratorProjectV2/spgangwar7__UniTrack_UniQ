package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.HolidayGrpDeptMapping;

public interface HolidayGroupDeptRepo extends JpaRepository<HolidayGrpDeptMapping, Integer>{
	
	@Query("select hgd from HolidayGrpDeptMapping hgd where hgd.departmentId=:deptID")
	List<HolidayGrpDeptMapping> getHolidayGrpDeptMapping(int deptID);

	@Modifying
	@Query("update HolidayGrpDeptMapping hgd set hgd.holidayGrpId=:holidayGrpId  where hgd.departmentId=:deptID")
	void updateHolidayGrpDept(Integer deptID, Integer holidayGrpId);
}
