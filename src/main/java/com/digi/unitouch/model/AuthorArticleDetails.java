package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 80055
 *
 */
@Entity
@Table(name="article_author")
public class AuthorArticleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="author_article_id")
	private Integer author_article_id;
	
	@Column(name="article_id")
	private Integer article_id;

	@Column(name="title")
	private String title;
	
	@Column(name="author_fname")
	private String fName;
	
	@Column(name="author_mname")
	private String mName;

	@Column(name="author_lname")
	private	String lName;

	@Column(name="email")
	private String eMail;
	
	@Column(name="is_corresponding")
	private String is_corresponding;
	
	@Column(name="orcid")
	private String orcid;
	
	@Column(name="author_order")
	private String author_order;
	
	@Column(name="copyright")
	private String copyright;
	
	@Column(name="copyright_agreement_content")
	private String copyrightAgreementContent;
	
	public Integer getAuthor_article_id() {
		return author_article_id;
	}

	public void setAuthor_article_id(Integer author_article_id) {
		this.author_article_id = author_article_id;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {

		if (mName.equalsIgnoreCase("@@@")) {
			return "";
		} else {
			return mName;
		}
	}

	public void setmName(String mName) {
	
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getIs_corresponding() {
		return is_corresponding;
	}

	public void setIs_corresponding(String is_corresponding) {
		this.is_corresponding = is_corresponding;
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public String getAuthor_order() {
		return author_order;
	}

	public void setAuthor_order(String author_order) {
		this.author_order = author_order;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getCopyrightAgreementContent() {
		return copyrightAgreementContent;
	}

	public void setCopyrightAgreementContent(String copyrightAgreementContent) {
		this.copyrightAgreementContent = copyrightAgreementContent;
	}

	@Override
	public String toString() {
		return "AuthorArticleDetails [author_article_id=" + author_article_id + ", article_id=" + article_id
				+ ", title=" + title + ", fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", eMail=" + eMail
				+ ", is_corresponding=" + is_corresponding + ", orcid=" + orcid + ", author_order=" + author_order
				+ ", copyright=" + copyright + ", copyrightAgreementContent=" + copyrightAgreementContent + "]";
	}

	
}
