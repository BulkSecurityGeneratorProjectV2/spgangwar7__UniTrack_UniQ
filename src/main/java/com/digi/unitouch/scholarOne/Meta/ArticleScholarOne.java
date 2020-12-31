package com.digi.unitouch.scholarOne.Meta;

import com.digi.unitouch.scholarOne.Main.ArticleConverterScholarOne;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("article_set")
public class ArticleScholarOne {

	@XStreamAlias("dtd_version")
	@XStreamAsAttribute
	private String ddtversion;

	@XStreamAlias("article")
	@XStreamConverter(ArticleConverterScholarOne.class)
	private ArticleConverterMeta articleConverterMeta;

	@XStreamAlias("article")
//	@XStreamImplicit
//	@XStreamConverter(ArticleConverterScholarOne.class)
	private Article article;

	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	@Override
	public String toString() {
		return "ArticleScholarOne [ddtversion=" + ddtversion + ", articleConverterMeta=" + articleConverterMeta
				+ ", article=" + article + "]";
	}

}
