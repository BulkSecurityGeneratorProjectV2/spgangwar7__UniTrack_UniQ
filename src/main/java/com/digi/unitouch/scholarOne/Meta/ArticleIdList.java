package com.digi.unitouch.scholarOne.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("article_id_list")
public class ArticleIdList {
	
	@XStreamAlias("article_id")
	private String article_id;

	@Override
	public String toString() {
		return "ArticleIdList [article_id=" + article_id + "]";
	}

	
}
