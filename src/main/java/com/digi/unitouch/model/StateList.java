package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class StateList {
	@Id
	@Column(name = "id",  nullable = false)
    private int id;
	@Column(name = "statename",  nullable = false)
    private String statename;
	
	@Column(name="country_id", nullable=false)
	private int countryId;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "StateList [id=" + id + ", statename=" + statename + ", countryId=" + countryId + "]";
	}

	
}
