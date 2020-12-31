package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("reviewer")
public class Reviewer {

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

	@XStreamAlias("orcid")
	private String orcid;
	
	@XStreamAlias("orcid_id_validation")
	private String orcidIdValidation;
	
	@XStreamAlias("orcid_token_type")
	private String orcidTokenType;
	
	@XStreamAlias("orcid_token_scope")
	private String orcidTokenScope;
	
	@XStreamAlias("orcid_token_expires_in")
	private String orcidTokenExpiresIn;
	
	
	@XStreamAlias("affiliation")
	@XStreamImplicit
	private List<Affiliation> affiliation;

	@XStreamAlias("current_profile_affiliation")
	private CurrentProfileAffiliation currentProfileAffiliation;

	@XStreamAlias("galleyDeliveryType")
	private String galleyDeliveryType;

	@XStreamAlias("response")
	@XStreamImplicit
	private List<String> response;
	
	@XStreamAlias("rating")
	private String rating;

	@Override
	public String toString() {
		return "Reviewer [salutation=" + salutation + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", suffix=" + suffix + ", degree=" + degree + ", email=" + email
				+ ", attrType=" + attrType + ", comments=" + comments + ", affiliation=" + affiliation
				+ ", currentProfileAffiliation=" + currentProfileAffiliation + ", galleyDeliveryType="
				+ galleyDeliveryType + ", response=" + response + "]";
	}

	
}
