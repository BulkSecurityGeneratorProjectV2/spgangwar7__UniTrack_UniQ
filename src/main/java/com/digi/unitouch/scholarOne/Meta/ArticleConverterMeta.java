package com.digi.unitouch.scholarOne.Meta;

public class ArticleConverterMeta {

	private String lang="";
	
	private String externalId="";
	
	private String exportDate="";
	
	private String msNo="";
	
	private String rev="";

	
	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public String getExportDate() {
		return exportDate;
	}


	public void setExportDate(String exportDate) {
		this.exportDate = exportDate;
	}


	public String getMsNo() {
		return msNo;
	}


	public void setMsNo(String msNo) {
		this.msNo = msNo;
	}


	public String getRev() {
		return rev;
	}


	public void setRev(String rev) {
		this.rev = rev;
	}


	@Override
	public String toString() {
		return "ArticleConverterMeta [lang=" + lang + ", externalId=" + externalId + ", exportDate=" + exportDate
				+ ", msNo=" + msNo + ", rev=" + rev + "]";
	}
	
	
}
