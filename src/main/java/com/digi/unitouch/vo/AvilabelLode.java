package com.digi.unitouch.vo;

import java.util.Date;



public class AvilabelLode {


	private Date date;
	
	private Long totalLoadCount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTotalLoadCount() {
		return totalLoadCount;
	}

	public void setTotalLoadCount(Long totalLoadCount) {
		this.totalLoadCount = totalLoadCount;
	}

	public AvilabelLode(Date date, Long totalLoadCount) {
		super();
		this.date = date;
		this.totalLoadCount = totalLoadCount;
	}

	@Override
	public String toString() {
		return "AvilabelLode [date=" + date + ", totalLoadCount=" + totalLoadCount + "]";
	}
	
	
	
	
	
	

	
	
	
	}
