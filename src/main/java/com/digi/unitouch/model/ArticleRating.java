package com.digi.unitouch.model;

/**
 * @author Aditya
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "article_rating")
public class ArticleRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "rating_value")
	private Integer star;
	
	
	@Column(name = "comments")
	private String comments;

	@Column(name = "article_id")
	private Integer article_id;

	@Column(name = "article_task_id")
	private Integer article_task_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getArticle_task_id() {
		return article_task_id;
	}

	public void setArticle_task_id(Integer article_task_id) {
		this.article_task_id = article_task_id;
	}

	@Override
	public String toString() {
		return "ArticleRating [id=" + id + ", star=" + star + ", comments=" + comments + ", article_id=" + article_id
				+ ", article_task_id=" + article_task_id + "]";
	}

	
	
	

}