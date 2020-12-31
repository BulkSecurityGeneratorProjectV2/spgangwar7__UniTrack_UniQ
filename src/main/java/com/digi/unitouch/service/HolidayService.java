package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.HolidayCalander;
import com.digi.unitouch.model.HolidayGroup;
import com.digi.unitouch.vo.HolidayVo;

public interface HolidayService {

	String createHolidayGroup(HolidayVo holidayVo);

	String deleteHolidayGroup(HolidayGroup holidayGroup);

	List<HolidayGroup> holiDayGroupList();

	String editHolidayGroup(HolidayGroup holidayGroup);

	List<HolidayGroup> getHolidayGroupByID(HolidayGroup holidayGroup);

	List<HolidayVo> getHolidayList();

	void saveNewHoliday(HolidayCalander holiday);

	void deleteHolidayDetails(HolidayCalander holiday);

	List<HolidayCalander> getHolidayListByID(HolidayCalander holiday);

	String createHolidayComboBox();

}
