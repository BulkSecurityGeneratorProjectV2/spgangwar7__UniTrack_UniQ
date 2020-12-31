package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.HolidayCalander;

public interface HolidayRepo extends JpaRepository<HolidayCalander, Integer> {

	@Query("Select hc FROM HolidayCalander hc WHERE hc.hcId=:hcId")
	List<HolidayCalander> getHolidayListByID(Integer hcId);

}
