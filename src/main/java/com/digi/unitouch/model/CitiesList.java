package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "cities")
public class CitiesList {
	@Id
	@Column(name = "id",  nullable = false)
    private int id;
	@Column(name = "cityname",  nullable = false)
    private String cityname;
	
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="country_id", nullable=false)
	private Country countryId;
	
	
	@Column(name = "state_id",  nullable = false)
    private int state_id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}


}
