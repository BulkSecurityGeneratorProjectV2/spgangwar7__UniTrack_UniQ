package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("abstract")
public class ArticleAbstract {

	@XStreamAlias("p")
	@XStreamAsAttribute
	private String articleParagraph="";

	@Override
	public String toString() {
		return "Abstract [articleParagraph=" + articleParagraph + "]";
	}
	
}
