package com.digi.unitouch.vo;
public class ArticleDataApi{
	private String  manuscriptCode;
	private String statusCode;
	private String manuscriptStatus;
	public ArticleDataApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDataApi(String manuscriptCode, String statusCode) {
		super();
		this.manuscriptCode = manuscriptCode;
		this.statusCode = statusCode;
	}

	
	public ArticleDataApi(String manuscriptCode, String manuscriptStatus,String statusCode) {
		super();
		this.manuscriptCode = manuscriptCode;
		this.manuscriptStatus = manuscriptStatus;
		this.statusCode = statusCode;
	}
	
	public String getManuscriptCode() {
		return manuscriptCode;
	}

	public void setManuscriptCode(String manuscriptCode) {
		this.manuscriptCode = manuscriptCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getManuscriptStatus() {
		return manuscriptStatus;
	}

	public void setManuscriptStatus(String manuscriptStatus) {
		this.manuscriptStatus = manuscriptStatus;
	}

	@Override
	public String toString() {
		return "ArticleDataApi [manuscriptCode=" + manuscriptCode + ", statusCode=" + statusCode + ", manuscriptStatus="
				+ manuscriptStatus + "]";
	}

	
}
