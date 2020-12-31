package com.digi.unitouch.vo;

import java.util.Date;



public class HourWiseChapterdeliverdVo {
	private Long count;
	private Integer theHour;
	private Date sch_start_time;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	public Integer getTheHour() {
		return theHour;
	}
	public void setTheHour(Integer theHour) {
		this.theHour = theHour;
	}
	public Date getSch_start_time() {
		return sch_start_time;
	}
	public void setSch_start_time(Date sch_start_time) {
		this.sch_start_time = sch_start_time;
	}
	@Override
	public String toString() {
		return "HourWiseChapterdeliverdVo [count=" + count + ", theHour=" + theHour + ", sch_start_time="
				+ sch_start_time + "]";
	}
	public HourWiseChapterdeliverdVo(Long count, Integer theHour, Date sch_start_time) {
		super();
		this.count = count;
		this.theHour = theHour;
		this.sch_start_time = sch_start_time;
	}
	
	
	
	
	
		
	
	}
