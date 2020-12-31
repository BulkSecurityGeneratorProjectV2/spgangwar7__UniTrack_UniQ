package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="publishers")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publisher_id")
	private Integer publisher_id;
	
	@Column(name = "publ_name")
	private String publisherName;

	@Column(name = "country_id")
	private Integer countryID;
	
	@OneToOne()
	@JoinColumn(name = "country_id",insertable = false,updatable = false)
	private Country country;

	
//	@OneToOne
//	@JoinColumn(name = "state_id", insertable = false, updatable = false)
//	private StateList stateList; 

	@Column(name = "state_id",  nullable = false)
	private String state;

//	@OneToOne
//	@JoinColumn(name = "city_id", insertable = false, updatable = false)
//	private CitiesList citiesList;

	@Column(name = "city_id",  nullable = false)
	private String city;
	
	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	
	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	public StateList getStateList() {
//		return stateList;
//	}
//
//	public void setStateList(StateList stateList) {
//		this.stateList = stateList;
//	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", publisherName=" + publisherName + ", countryID="
				+ countryID + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}

//	public CitiesList getCitiesList() {
//		return citiesList;
//	}
//
//	public void setCitiesList(CitiesList citiesList) {
//		this.citiesList = citiesList;
//	}

	
	
}
