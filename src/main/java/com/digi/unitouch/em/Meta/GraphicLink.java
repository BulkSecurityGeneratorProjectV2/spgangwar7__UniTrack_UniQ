package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class GraphicLink {

	@XStreamAlias("xlink:href")
	private String href="";
	
	@XStreamAlias("xmlns:xlink")
	private String xlink="";
	
	private String value;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getXlink() {
		return xlink;
	}

	public void setXlink(String xlink) {
		this.xlink = xlink;
	}

	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "GraphicLink [href=" + href + ", xlink=" + xlink + ", value=" + value + "]";
	}


}
