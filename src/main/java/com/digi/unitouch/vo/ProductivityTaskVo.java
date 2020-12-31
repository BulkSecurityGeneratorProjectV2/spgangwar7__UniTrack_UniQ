package com.digi.unitouch.vo;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductivityTaskVo{
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
	
	public long count;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ProductivityTaskVo [date=" + date + ", count=" + count + "]";
	}
	public ProductivityTaskVo(Date date, long count) {
		super();
		this.date = date;
		this.count = count;
	}
	
	
	
	
}
