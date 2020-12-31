package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("author")
public class Author {

	@XStreamAlias("auth_URL")
	@XStreamAsAttribute
	private String auth_URL;

	@XStreamAlias("author_seq")
	@XStreamAsAttribute
	private String author_seq;

	@XStreamAlias("corr")
	@XStreamAsAttribute
	private String corr;

	@XStreamAlias("user_id")
	@XStreamAsAttribute
	private String user_id;

	@XStreamAlias("salutation")
	private String salutation;

	@XStreamAlias("first_name")
	private String firstName;

	@XStreamAlias("middle_name")
	private String middleName="";

	@XStreamAlias("last_name")
	private String lastName;

	@XStreamAlias("suffix")
	private String suffix;

	@XStreamAlias("degree")
	private String degree;

	@XStreamAlias("email")
	@XStreamImplicit
	private List<String> email;

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
	
	@XStreamAlias("researcher_id")
	private String researcherId;
	
	@XStreamAlias("affiliation")
	@XStreamImplicit
	private List<Affiliation> affiliation;
	
	@XStreamAlias("profile_affiliation")
	private ProfileAffiliation profileAffiliation;
	
	@XStreamAlias("current_profile_affiliation")
	private CurrentProfileAffiliation currentProfileAffiliation;
	
	@XStreamAlias("galleyDeliveryType")
	private String galleyDeliveryType;

	
	public String getAuth_URL() {
		return auth_URL;
	}

	public void setAuth_URL(String auth_URL) {
		this.auth_URL = auth_URL;
	}

	public String getAuthor_seq() {
		return author_seq;
	}

	public void setAuthor_seq(String author_seq) {
		this.author_seq = author_seq;
	}

	public String getCorr() {
		return corr;
	}

	public void setCorr(String corr) {
		this.corr = corr;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public AuthorAttrType getAttrType() {
		return attrType;
	}

	public void setAttrType(AuthorAttrType attrType) {
		this.attrType = attrType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public String getOrcidIdValidation() {
		return orcidIdValidation;
	}

	public void setOrcidIdValidation(String orcidIdValidation) {
		this.orcidIdValidation = orcidIdValidation;
	}

	public String getOrcidTokenType() {
		return orcidTokenType;
	}

	public void setOrcidTokenType(String orcidTokenType) {
		this.orcidTokenType = orcidTokenType;
	}

	public String getOrcidTokenScope() {
		return orcidTokenScope;
	}

	public void setOrcidTokenScope(String orcidTokenScope) {
		this.orcidTokenScope = orcidTokenScope;
	}

	public String getOrcidTokenExpiresIn() {
		return orcidTokenExpiresIn;
	}

	public void setOrcidTokenExpiresIn(String orcidTokenExpiresIn) {
		this.orcidTokenExpiresIn = orcidTokenExpiresIn;
	}

	public String getResearcherId() {
		return researcherId;
	}

	public void setResearcherId(String researcherId) {
		this.researcherId = researcherId;
	}

	public List<Affiliation> getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(List<Affiliation> affiliation) {
		this.affiliation = affiliation;
	}

	public ProfileAffiliation getProfileAffiliation() {
		return profileAffiliation;
	}

	public void setProfileAffiliation(ProfileAffiliation profileAffiliation) {
		this.profileAffiliation = profileAffiliation;
	}

	public CurrentProfileAffiliation getCurrentProfileAffiliation() {
		return currentProfileAffiliation;
	}

	public void setCurrentProfileAffiliation(CurrentProfileAffiliation currentProfileAffiliation) {
		this.currentProfileAffiliation = currentProfileAffiliation;
	}

	public String getGalleyDeliveryType() {
		return galleyDeliveryType;
	}

	public void setGalleyDeliveryType(String galleyDeliveryType) {
		this.galleyDeliveryType = galleyDeliveryType;
	}

	@Override
	public String toString() {
		return "Author [auth_URL=" + auth_URL + ", author_seq=" + author_seq + ", corr=" + corr + ", user_id=" + user_id
				+ ", salutation=" + salutation + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", suffix=" + suffix + ", degree=" + degree + ", email=" + email
				+ ", attrType=" + attrType + ", comments=" + comments + ", affiliation=" + affiliation
				+ ", profileAffiliation=" + profileAffiliation + ", currentProfileAffiliation="
				+ currentProfileAffiliation + ", galleyDeliveryType=" + galleyDeliveryType + "]";
	}

	

}
