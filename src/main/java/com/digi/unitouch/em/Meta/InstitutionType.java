package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class InstitutionType {

	@XStreamAlias("content-type")
	private String contentType="";
	
	private String value;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "InstitutionType [contentType=" + contentType + ", value=" + value + "]";
	}


}
