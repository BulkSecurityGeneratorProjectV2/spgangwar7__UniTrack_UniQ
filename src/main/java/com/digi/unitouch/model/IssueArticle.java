package com.digi.unitouch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "issue_article")
public class IssueArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ia_id")
	private Integer iaId;
	
	@Column(name = "article_id")
	private Integer articleId;

	@Column(name = "issue_id")
	private Integer issueId;

	public Integer getIaId() {
		return iaId;
	}

	public void setIaId(Integer iaId) {
		this.iaId = iaId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	@Override
	public String toString() {
		return "IssueArticle [iaId=" + iaId + ", articleId=" + articleId + ", issueId=" + issueId + "]";
	}

	

}
