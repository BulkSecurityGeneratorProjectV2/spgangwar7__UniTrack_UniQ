package com.digi.unitouch.vo;

public class ingestionvo {

	private String aid;
	
	private String article_doi;
	
	private String journalAbbrName;
	
	private String file;
	private String articletype;
	private String articletitle;
	


	public String getArticletitle() {
		return articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	
	public String getArticle_doi() {
		return article_doi;
	}

	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	public String getJournalAbbrName() {
		return journalAbbrName;
	}

	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getArticletype() {
		return articletype;
	}

	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}

	@Override
	public String toString() {
		return "ingestionvo [aid=" + aid + ", article_doi=" + article_doi + ", journalAbbrName=" + journalAbbrName
				+ ", file=" + file + ", articletype=" + articletype + "]";
	}

	

	}
