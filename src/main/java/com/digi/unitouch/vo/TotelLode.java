package com.digi.unitouch.vo;

public class TotelLode {


	
	private String dname;
	
	private Long totalLoadCount;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Long getTotalLoadCount() {
		return totalLoadCount;
	}

	public void setTotalLoadCount(Long totalLoadCount) {
		this.totalLoadCount = totalLoadCount;
	}

	public TotelLode(String dname, Long totalLoadCount) {
		super();
		this.dname = dname;
		this.totalLoadCount = totalLoadCount;
	}

	@Override
	public String toString() {
		return "TotelLode [dname=" + dname + ", totalLoadCount=" + totalLoadCount + "]";
	}
	
	
	
	
	

	
	
	

	
	
	
	}
