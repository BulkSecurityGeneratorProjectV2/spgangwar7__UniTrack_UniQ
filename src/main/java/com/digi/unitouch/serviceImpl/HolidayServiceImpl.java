package com.digi.unitouch.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.HolidayCalander;
import com.digi.unitouch.model.HolidayGroup;
import com.digi.unitouch.repository.HolidayGroupRepo;
import com.digi.unitouch.repository.HolidayRepo;
import com.digi.unitouch.service.HolidayService;
import com.digi.unitouch.vo.HolidayVo;

@Service
@Transactional
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	HolidayRepo holidayRepo;

	@Autowired
	HolidayGroupRepo holidayGroupRepo;

	@Override
	public String createHolidayGroup(HolidayVo holidayVo) {

		HolidayGroup holidayGroup = new HolidayGroup();
		holidayGroup.setHolidayGrpName(holidayVo.getHolidayGroupName());
		holidayGroupRepo.save(holidayGroup);
		return "Holiday Group Created Successfully.";
	}

	@Override
	public String deleteHolidayGroup(HolidayGroup holidayGroup) {
		holidayGroupRepo.delete(holidayGroup);
		return "Holiday Group Deleted Successfully.";
	}

	@Override
	public List<HolidayGroup> holiDayGroupList() {
		return holidayGroupRepo.findAll();
	}

	@Override
	public String editHolidayGroup(HolidayGroup holidayGroup) {
		holidayGroupRepo.save(holidayGroup);
		return "HoliDay Group is Updated";
	}

	@Override
	public List<HolidayGroup> getHolidayGroupByID(HolidayGroup holidayGroup) {
		return holidayGroupRepo.findByHoliDayGroupId(holidayGroup.getHolidayGrpId());
	}

	@Override
	public List<HolidayVo> getHolidayList() {
		
		List<HolidayCalander> getholidayList = holidayRepo.findAll();
		
		List<HolidayVo> holidayList = new ArrayList<HolidayVo>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for (HolidayCalander holidayCalander : getholidayList) {
			
			HolidayVo holidayVo = new HolidayVo();
			holidayVo.setHolidayID(holidayCalander.getHcId());
			holidayVo.setHolidayName(holidayCalander.getHolidayName());
			holidayVo.setHolidayStartDate(sdf.format(holidayCalander.getHolidayStartDate()));
			holidayVo.setHolidayEndDate(sdf.format(holidayCalander.getHolidayEndDate()));
			holidayVo.setHolidayGroupID(holidayCalander.getHolidayGroup().getHolidayGrpId());
			holidayVo.setHolidayGroupName(holidayCalander.getHolidayGroup().getHolidayGrpName());
			holidayList.add(holidayVo);
			
		}
		return holidayList;
	}
	
	@Override
	public void saveNewHoliday(HolidayCalander holiday) {
		holidayRepo.save(holiday);
		
	}

	@Override
	public void deleteHolidayDetails(HolidayCalander holiday) {
		holidayRepo.delete(holiday);
		
	}

	@Override
	public List<HolidayCalander> getHolidayListByID(HolidayCalander holiday) {
		return holidayRepo.getHolidayListByID(holiday.getHcId());
	}

	@Override
	public String createHolidayComboBox() {
		
		StringBuilder builder = new StringBuilder();
		
		List<HolidayGroup> holidayGroupList = holidayGroupRepo.findAll();
		
		builder.append("<label for=\"ExpertiseLevel\"> Holiday Group </label>");
		builder.append("<select id=\"holidayGroupCombo\" style=\"width: 100%;\" class=\"form-control\">");
		builder.append("<option selected=\"selected\"> Select A Group ...</option>");
		for (HolidayGroup holidayGroup : holidayGroupList) {
			builder.append("<option value=\""+holidayGroup.getHolidayGrpId()+"\">"+holidayGroup.getHolidayGrpName()+"</option>");
		}
		
		return builder.toString();
	}

	
}
