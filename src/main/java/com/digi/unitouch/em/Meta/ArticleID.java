package com.digi.unitouch.em.Meta;

public class ArticleID {

private String pubIdType="";
	
	private String value="";

	public String getPubIdType() {
		return pubIdType;
	}

	public void setPubIdType(String pubIdType) {
		this.pubIdType = pubIdType;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ArticleID [pubIdType=" + pubIdType + ", value=" + value + "]";
	}
	
}
