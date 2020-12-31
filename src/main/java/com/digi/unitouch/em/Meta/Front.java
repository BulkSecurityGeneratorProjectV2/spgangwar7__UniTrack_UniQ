package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("front")
public class Front {
	
	@XStreamAlias("journal-meta")
	private JournalMeta journalMeta; 
	
	@XStreamAlias("body")
	private String body;
	
	@XStreamAlias("article-meta")
	private ArticleMeta articleMeta;

	public void setBody(String body) {
		this.body = body;
	}

	
	public JournalMeta getJournalMeta() {
		return journalMeta;
	}


	public void setJournalMeta(JournalMeta journalMeta) {
		this.journalMeta = journalMeta;
	}


	public ArticleMeta getArticleMeta() {
		return articleMeta;
	}


	public void setArticleMeta(ArticleMeta articleMeta) {
		this.articleMeta = articleMeta;
	}


	public String getBody() {
		return body;
	}


	@Override
	public String toString() {
		return "Front [journalMeta=" + journalMeta + ", body=" + body + ", articleMeta=" + articleMeta + "]";
	}

	
     
  
}