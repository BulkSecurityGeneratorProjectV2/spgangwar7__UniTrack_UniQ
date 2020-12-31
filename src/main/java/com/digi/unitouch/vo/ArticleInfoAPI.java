package com.digi.unitouch.vo;

import java.util.List;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.model.Journal;

public class ArticleInfoAPI {
	private List<AuthorArticleDetails> authors;
	private ArticleDetail article;
	private Journal journal;
	private String journalAbbr;
	public ArticleInfoAPI() {
		super();
	}

	public ArticleInfoAPI(List<AuthorArticleDetails> authors, ArticleDetail article, Journal journal,String journalAbbr) {
		super();
		this.authors = authors;
		this.article = article;
		this.journal = journal;
		this.journalAbbr=journalAbbr;
	}

	public List<AuthorArticleDetails> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorArticleDetails> authors) {
		this.authors = authors;
	}

	public ArticleDetail getArticle() {
		return article;
	}

	public void setArticle(ArticleDetail article) {
		this.article = article;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public String getJournalAbbr() {
		return journalAbbr;
	}

	public void setJournalAbbr(String journalAbbr) {
		this.journalAbbr = journalAbbr;
	}

	@Override
	public String toString() {
		return "ArticleInfoAPI [authors=" + authors + ", article=" + article + ", journal=" + journal + ", journalAbbr="
				+ journalAbbr + "]";
	}

}
