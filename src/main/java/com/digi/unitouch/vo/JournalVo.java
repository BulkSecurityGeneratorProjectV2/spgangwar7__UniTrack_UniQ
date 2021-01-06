package com.digi.unitouch.vo;

public class JournalVo {

	private String journalAcronym;
	private String partnername;
	private String journalTitle;
	private String partnerContact;
	private String shortTitle;
	private String INGESTIONMethod;
	private String oAStatus;
	private String houseStyle;
	private String onlineIssn;
	private String pageLayout;
	private String printIssn;
	private String publicationType;
	private String issnDoi;
	private String sequentialIssue;
	private String journalComments;
	private String doiPrefix;
	private String coden;
	private String creationRule;
	private String articleID;
	private int publisher_id;
	private String fromEmail;
	private String fromPassword;
	private String journalType;
	private Integer examID;
//	/*Prduction Workflow  Info*/
//	private String articleWorkflow;
//	private String directProofing;
//	private String issueWorkflow;
//	private String preProofreadCheck;
//	private String forthcomingArticles;
//	private String languageEditing;
//	private String acceptedManuscript;
//	private String proofreading;
//	private String autoAssess;
//	private String showDigiEditLink;
//	private String authorProofing;
//	/*People Information*/
//	private String assign;
//	private String prePress;
//	private String editorName;
//	private String xmlNotificatio;
//	private String signature;
//	private String supplierContact;
//	private String 	eMail;
//	
//	/*Article Information*/
//	private String 	regularArticle;
//	private String 	specialArticle;
//	private String 	shortFastArticle;
//	private String 	reviewFastArticle;
//	private String 	other;
//	private String 	corrections;
//	
	
	
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getJournalAcronym() {
		return journalAcronym;
	}
	public void setJournalAcronym(String journalAcronym) {
		this.journalAcronym = journalAcronym;
	}
	public String getPartnername() {
		return partnername;
	}
	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
	public String getJournalTitle() {
		return journalTitle;
	}
	public void setJournalTitle(String journalTitle) {
		this.journalTitle = journalTitle;
	}
	public String getPartnerContact() {
		return partnerContact;
	}
	public void setPartnerContact(String partnerContact) {
		this.partnerContact = partnerContact;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public String getINGESTIONMethod() {
		return INGESTIONMethod;
	}
	public void setINGESTIONMethod(String iNGESTIONMethod) {
		INGESTIONMethod = iNGESTIONMethod;
	}
	public String getoAStatus() {
		return oAStatus;
	}
	public void setoAStatus(String oAStatus) {
		this.oAStatus = oAStatus;
	}
	public String getHouseStyle() {
		return houseStyle;
	}
	public void setHouseStyle(String houseStyle) {
		this.houseStyle = houseStyle;
	}
	public String getOnlineIssn() {
		return onlineIssn;
	}
	public void setOnlineIssn(String onlineIssn) {
		this.onlineIssn = onlineIssn;
	}
	public String getPageLayout() {
		return pageLayout;
	}
	public void setPageLayout(String pageLayout) {
		this.pageLayout = pageLayout;
	}
	public String getPrintIssn() {
		return printIssn;
	}
	public void setPrintIssn(String printIssn) {
		this.printIssn = printIssn;
	}
	public String getPublicationType() {
		return publicationType;
	}
	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}
	public String getIssnDoi() {
		return issnDoi;
	}
	public void setIssnDoi(String issnDoi) {
		this.issnDoi = issnDoi;
	}
	public String getSequentialIssue() {
		return sequentialIssue;
	}
	public void setSequentialIssue(String sequentialIssue) {
		this.sequentialIssue = sequentialIssue;
	}
	public String getJournalComments() {
		return journalComments;
	}
	public void setJournalComments(String journalComments) {
		this.journalComments = journalComments;
	}
	public String getDoiPrefix() {
		return doiPrefix;
	}
	public void setDoiPrefix(String doiPrefix) {
		this.doiPrefix = doiPrefix;
	}
	public String getCoden() {
		return coden;
	}
	public void setCoden(String coden) {
		this.coden = coden;
	}
	public String getCreationRule() {
		return creationRule;
	}
	public void setCreationRule(String creationRule) {
		this.creationRule = creationRule;
	}
	public String getArticleID() {
		return articleID;
	}
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
	

	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getFromPassword() {
		return fromPassword;
	}
	public void setFromPassword(String fromPassword) {
		this.fromPassword = fromPassword;
	}
	
	public String getJournalType() {
		return journalType;
	}
	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}
	
	public Integer getExamID() {
		return examID;
	}
	public void setExamID(Integer examID) {
		this.examID = examID;
	}
	@Override
	public String toString() {
		return "JournalVo [journalAcronym=" + journalAcronym + ", partnername=" + partnername + ", journalTitle="
				+ journalTitle + ", partnerContact=" + partnerContact + ", shortTitle=" + shortTitle
				+ ", INGESTIONMethod=" + INGESTIONMethod + ", oAStatus=" + oAStatus + ", houseStyle=" + houseStyle
				+ ", onlineIssn=" + onlineIssn + ", pageLayout=" + pageLayout + ", printIssn=" + printIssn
				+ ", publicationType=" + publicationType + ", issnDoi=" + issnDoi + ", sequentialIssue="
				+ sequentialIssue + ", journalComments=" + journalComments + ", doiPrefix=" + doiPrefix + ", coden="
				+ coden + ", creationRule=" + creationRule + ", articleID=" + articleID + ", publisher_id="
				+ publisher_id + ", fromEmail=" + fromEmail + ", fromPassword=" + fromPassword + ", journalType="
				+ journalType + ", examID=" + examID + "]";
	}

	

	
	
}
