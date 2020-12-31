package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.HolidayGroup;

public interface HolidayGroupRepo extends JpaRepository<HolidayGroup, Integer> {
	
	@Query("Select hgrp FROM HolidayGroup hgrp WHERE hgrp.holidayGrpId=:holidayGrpId")
	List<HolidayGroup> findByHoliDayGroupId(Integer holidayGrpId);

}
