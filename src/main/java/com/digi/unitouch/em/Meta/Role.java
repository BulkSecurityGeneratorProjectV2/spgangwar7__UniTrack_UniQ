package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
@XStreamAlias("role")
public class Role {
	
	@XStreamAlias("content-type")
	@XStreamAsAttribute
	private String contentType="";
	
	private String value="";

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
		return "Role [contentType=" + contentType + ", value=" + value + "]";
	}

}

