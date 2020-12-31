package com.digi.unitouch.vo;

import java.util.Date;
import java.util.List;

import com.digi.unitouch.util.DateApi;



public class Article
{
	public Article() {}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", articletype=" + articletype + ", CurrentPhase="
				+ CurrentPhase + ", keywords=" + keywords + ", articleFile=" + articleFile + ", firstpagefile="
				+ firstpagefile + ", doi=" + doi + ", qr_code=" + qr_code + ", author=" + authors + ", files=" + files
				+ ", SubmissionDate=" + SubmissionDate + ", AcceptedDate=" + AcceptedDate + "]";
	}
	String id;
	String title;
	String articletype;
	String wordCount="0";
	String CurrentPhase;
	String keywords="";
	String articleFile;
	String firstpagefile;
	String doi;
	String qr_code;
	List<Author> authors;
	List<Attachment> files;
	String SubmissionDate="";
	String AcceptedDate=""+DateApi.getCurrentIndianTimeyyyy();
	String review="";
	String commentoForProduction="";
	/**
	 * @return the acceptedDate
	 */
	public String getAcceptedDate() {
		return AcceptedDate;
	}
	/**
	 * @param acceptedDate the acceptedDate to set
	 */
	public void setAcceptedDate(String acceptedDate) {
		AcceptedDate = acceptedDate;
	}
	public String getSubmissionDate() {
		return SubmissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		SubmissionDate = submissionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticletype() {
		return articletype;
	}
	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}
	public String getCurrentPhase() {
		return CurrentPhase;
	}
	public void setCurrentPhase(String currentPhase) {
		CurrentPhase = currentPhase;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getArticleFile() {
		return articleFile;
	}
	public void setArticleFile(String articleFile) {
		this.articleFile = articleFile;
	}
	public String getFirstpagefile() {
		return firstpagefile;
	}
	public void setFirstpagefile(String firstpagefile) {
		this.firstpagefile = firstpagefile;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public String getQr_code() {
		return qr_code;
	}
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public List<Author> getAuthor() {
		return authors;
	}
	public void setAuthor(List<Author> authors) {
		this.authors = authors;
	}
	public List<Attachment> getFiles() {
		return files;
	}
	public void setFiles(List<Attachment> files) {
		this.files = files;
	}
	public String getCommentoForProduction() {
		return commentoForProduction;
	}
	public void setCommentoForProduction(String commentoForProduction) {
		this.commentoForProduction = commentoForProduction;
	}
	public String getWordCount() {
		return wordCount;
	}
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	
	

}
