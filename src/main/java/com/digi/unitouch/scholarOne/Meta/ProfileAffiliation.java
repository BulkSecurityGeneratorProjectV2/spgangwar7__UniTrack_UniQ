package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("profile_affiliation")
public class ProfileAffiliation {
	
	@XStreamAlias("inst")
	private String inst;
	
	@XStreamAlias("institution_id")
	private String institutionId;
	
	@XStreamAlias("dept")
	private String dept;
	
	@XStreamAlias("person_title")
	private String personTitle;
	
	@XStreamAlias("room")
	private String room;
	
	@XStreamAlias("addr1")
	private String addr1;
	
	@XStreamAlias("addr2")
	private String addr2;
	
	@XStreamAlias("addr3")
	private String addr3;
	
	@XStreamAlias("city")
	private String city;
	
	@XStreamAlias("state")
	private String state;
	
	@XStreamAlias("province")
	private String province;
	
	@XStreamAlias("country")
	private String country;
	
	@XStreamAlias("post_code")
	private String postCode;
	
	@XStreamAlias("phone")
	private String phone;
	
	@XStreamAlias("fax")
	private String fax;

	@Override
	public String toString() {
		return "ProfileAffiliation [inst=" + inst + ", institutionId=" + institutionId + ", dept=" + dept
				+ ", personTitle=" + personTitle + ", room=" + room + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", addr3=" + addr3 + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", postCode=" + postCode + ", phone=" + phone + ", fax=" + fax + "]";
	}

	

	
}

