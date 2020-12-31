package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("article")
public class Article {

	@XStreamAlias("article-type")
	@XStreamAsAttribute
	private String articleType;
	
	@XStreamAlias("dtd-version")
	@XStreamAsAttribute
	private String ddtversion;

	@XStreamAlias("front")
	private Front front;
	
	@XStreamAlias("body")
	private Body body;

	
	public String getArticleType() {
		return articleType;
	}


	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}


	public String getDdtversion() {
		return ddtversion;
	}


	public void setDdtversion(String ddtversion) {
		this.ddtversion = ddtversion;
	}


	public Front getFront() {
		return front;
	}


	public void setFront(Front front) {
		this.front = front;
	}


	public Body getBody() {
		return body;
	}


	public void setBody(Body body) {
		this.body = body;
	}


	@Override
	public String toString() {
		return "Article [articleType=" + articleType + ", ddtversion=" + ddtversion + ", front=" + front + ", body="
				+ body + "]";
	}


}
