package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("editor")
public class Editor {
	
	@XStreamAlias("salutation")
	private String salutation;
	
	@XStreamAlias("first_name")
	private String first_name;
	
	@XStreamAlias("middle_name")
	private String middle_name;
	
	@XStreamAlias("last_name")
	private String last_name;
	
	@XStreamAlias("suffix")
	private String suffix;
	
	@XStreamAlias("degree")
	private String degree;
	
	@XStreamAlias("email")
	private String email;
	
	@XStreamAlias("attr_type")
	private AuthorAttrType attrType;
	
	@XStreamAlias("comments")
	private String comments;
	
	@XStreamAlias("affiliation")
	private Affiliation affiliation;
	

	@XStreamAlias("current_profile_affiliation")
	private CurrentProfileAffiliation currentProfileAffiliation;
	
	@XStreamAlias("galleyDeliveryType")
	private String galleyDeliveryType;

	@Override
	public String toString() {
		return "Editor [salutation=" + salutation + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", suffix=" + suffix + ", degree=" + degree + ", email=" + email
				+ ", attrType=" + attrType + ", comments=" + comments + ", affiliation=" + affiliation
				+ ", currentProfileAffiliation=" + currentProfileAffiliation + ", galleyDeliveryType="
				+ galleyDeliveryType + "]";
	}
	
	
	}


