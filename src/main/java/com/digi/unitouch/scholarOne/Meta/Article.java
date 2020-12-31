package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author 80065
 *
 */
@XStreamAlias("article")
public class Article  {

	@XStreamAlias("lang")
	@XStreamAsAttribute
	private String lang;
	
	@XStreamAlias("external_id")
	@XStreamAsAttribute
	private String externalId;
	
	@XStreamAlias("export_date")
	@XStreamAsAttribute
	private String exportDate;
	
	@XStreamAlias("ms_no")
	@XStreamAsAttribute
	private String msNo;
	
	@XStreamAlias("rev")
	@XStreamAsAttribute
	private String rev;
	
	@XStreamAlias("journal")
	private Journal journal;

	@XStreamAlias("replaces")
	private String replaces;
	
	@XStreamAlias("article_status")
	private String articleStatus;
	
	@XStreamAlias("article_title")
	private String articleTitle;
	
	@XStreamAlias("article_sub_title")
	private String articleSubTitle;

	@XStreamAlias("vernacular_title")
	private String vernacularTitle;
	
	@XStreamAlias("author_list")
	private AuthorList authorList;
	
	@XStreamAlias("author_comments")
	private AuthorList authorComments;
	
	@XStreamAlias("editor_list")
	private EditorList editorList;
	
	@XStreamAlias("reviewer_list")
	private ReviewerList reviewerList;
	
	@XStreamAlias("publication_type")
	private String publicationType;
	
	@XStreamAlias("article_id_list")
	private ArticleIdList articleIdList;
	
	@XStreamAlias("file_list")
	private FileList fileList;
	
	
	@XStreamAlias("history")
	private History history;

	@XStreamAlias("fulltext_url")
	private String fulltext_url;
	
	@XStreamAlias("abstract")
	private String aabstract;
	
	@XStreamOmitField
	@XStreamAlias("configurable_data_fields")
	private Object configurable_data_fields;
	
	@XStreamAlias("notes")
	private String notes;
	
	@XStreamOmitField
	@XStreamAlias("content")
	private Object content;
	
	@XStreamOmitField
	@XStreamAlias("office_contact")
	private Object officeContact;
	
	@XStreamAlias("lte_text_area")
	private String lteTextArea;
	
	@XStreamOmitField
	@XStreamAlias("email_list")
	private String emailList;
	
	
	@XStreamOmitField
	@XStreamAlias("user_list")
	private Object userList;
	
	
	@XStreamOmitField
	@XStreamAlias("fundref_information")
	private Object fundrefInformation;
	
	@XStreamAlias("conversations")
	private String conversations;

	
	
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



	public Journal getJournal() {
		return journal;
	}



	public void setJournal(Journal journal) {
		this.journal = journal;
	}



	public String getReplaces() {
		return replaces;
	}



	public void setReplaces(String replaces) {
		this.replaces = replaces;
	}



	public String getArticleStatus() {
		return articleStatus;
	}



	public void setArticleStatus(String articleStatus) {
		this.articleStatus = articleStatus;
	}



	public String getArticleTitle() {
		return articleTitle;
	}



	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}



	public String getArticleSubTitle() {
		return articleSubTitle;
	}



	public void setArticleSubTitle(String articleSubTitle) {
		this.articleSubTitle = articleSubTitle;
	}



	public String getVernacularTitle() {
		return vernacularTitle;
	}



	public void setVernacularTitle(String vernacularTitle) {
		this.vernacularTitle = vernacularTitle;
	}



	public AuthorList getAuthorList() {
		return authorList;
	}



	public void setAuthorList(AuthorList authorList) {
		this.authorList = authorList;
	}



	public AuthorList getAuthorComments() {
		return authorComments;
	}



	public void setAuthorComments(AuthorList authorComments) {
		this.authorComments = authorComments;
	}



	public EditorList getEditorList() {
		return editorList;
	}



	public void setEditorList(EditorList editorList) {
		this.editorList = editorList;
	}



	public ReviewerList getReviewerList() {
		return reviewerList;
	}



	public void setReviewerList(ReviewerList reviewerList) {
		this.reviewerList = reviewerList;
	}



	public String getPublicationType() {
		return publicationType;
	}



	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}



	public ArticleIdList getArticleIdList() {
		return articleIdList;
	}



	public void setArticleIdList(ArticleIdList articleIdList) {
		this.articleIdList = articleIdList;
	}



	public FileList getFileList() {
		return fileList;
	}



	public void setFileList(FileList fileList) {
		this.fileList = fileList;
	}



	public History getHistory() {
		return history;
	}



	public void setHistory(History history) {
		this.history = history;
	}



	public String getFulltext_url() {
		return fulltext_url;
	}



	public void setFulltext_url(String fulltext_url) {
		this.fulltext_url = fulltext_url;
	}



	public String getAabstract() {
		return aabstract;
	}



	public void setAabstract(String aabstract) {
		this.aabstract = aabstract;
	}



	public Object getConfigurable_data_fields() {
		return configurable_data_fields;
	}



	public void setConfigurable_data_fields(Object configurable_data_fields) {
		this.configurable_data_fields = configurable_data_fields;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public Object getContent() {
		return content;
	}



	public void setContent(Object content) {
		this.content = content;
	}



	public Object getOfficeContact() {
		return officeContact;
	}



	public void setOfficeContact(Object officeContact) {
		this.officeContact = officeContact;
	}



	public String getLteTextArea() {
		return lteTextArea;
	}



	public void setLteTextArea(String lteTextArea) {
		this.lteTextArea = lteTextArea;
	}



	public String getEmailList() {
		return emailList;
	}



	public void setEmailList(String emailList) {
		this.emailList = emailList;
	}



	public Object getUserList() {
		return userList;
	}



	public void setUserList(Object userList) {
		this.userList = userList;
	}



	public Object getFundrefInformation() {
		return fundrefInformation;
	}



	public void setFundrefInformation(Object fundrefInformation) {
		this.fundrefInformation = fundrefInformation;
	}



	public String getConversations() {
		return conversations;
	}



	public void setConversations(String conversations) {
		this.conversations = conversations;
	}

	@Override
	public String toString() {
		return "Article [lang=" + lang + ", externalId=" + externalId + ", exportDate=" + exportDate + ", msNo=" + msNo
				+ ", rev=" + rev + ", journal=" + journal + ", replaces=" + replaces + ", articleStatus="
				+ articleStatus + ", articleTitle=" + articleTitle + ", articleSubTitle=" + articleSubTitle
				+ ", vernacularTitle=" + vernacularTitle + ", authorList=" + authorList + ", authorComments="
				+ authorComments + ", editorList=" + editorList + ", reviewerList=" + reviewerList
				+ ", publicationType=" + publicationType + ", articleIdList=" + articleIdList + ", fileList=" + fileList
				+ ", history=" + history + ", fulltext_url=" + fulltext_url + ", aabstract=" + aabstract
				+ ", configurable_data_fields=" + configurable_data_fields + ", notes=" + notes + ", content=" + content
				+ ", officeContact=" + officeContact + ", lteTextArea=" + lteTextArea + ", emailList=" + emailList
				+ ", userList=" + userList + ", fundrefInformation=" + fundrefInformation + ", conversations="
				+ conversations + "]";
	}

}
