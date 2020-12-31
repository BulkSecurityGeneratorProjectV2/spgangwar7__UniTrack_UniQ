package com.digi.unitouch.em.Meta;

public class AddrLine {

	private String contentType = "";

	private String value = "";

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
		return "AddrLine [contentType=" + contentType + ", value=" + value + "]";
	}

}
