package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Date {
	
	@XStreamAlias("date-type")
	@XStreamAsAttribute
	private String dateType;
	

	@XStreamAlias("day")
	@XStreamAsAttribute
	private String day;
	
	@XStreamAlias("month")
	@XStreamAsAttribute
	private String month;
	
	@XStreamAlias("year")
	@XStreamAsAttribute
	private String year;

	
	
	public String getDateType() {
		return dateType;
	}



	public void setDateType(String dateType) {
		this.dateType = dateType;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	@Override
	public String toString() {
		return "Date [dateType=" + dateType + ", day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
