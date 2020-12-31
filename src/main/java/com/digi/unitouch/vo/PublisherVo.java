package com.digi.unitouch.vo;

public class PublisherVo {
	
	private String publisherName = "";
	private String cityName = "";
	private Integer countryID;
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getCountryID() {
		return countryID;
	}
	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}
	@Override
	public String toString() {
		return "PublisherVo [publisherName=" + publisherName + ", cityName=" + cityName + ", countryID=" + countryID
				+ "]";
	}
}
