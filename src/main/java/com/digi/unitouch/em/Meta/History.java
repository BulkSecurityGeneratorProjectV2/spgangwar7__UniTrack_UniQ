package com.digi.unitouch.em.Meta;

import java.util.List;

import com.digi.unitouch.em.converter.DateConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("history")
public class History {


	@XStreamAlias("date")
	@XStreamImplicit
	@XStreamConverter(DateConverter.class)
	private List<Date> date;

	
	
	public List<Date> getDate() {
		return date;
	}



	public void setDate(List<Date> date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "History [date=" + date + "]";
	}

	
}

