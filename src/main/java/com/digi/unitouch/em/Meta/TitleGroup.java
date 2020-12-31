package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("title-group")
public class TitleGroup {
	@XStreamAlias("article-title")
	private String Articletitle;
	

	@XStreamAlias("alt-title")
	private String altTitle;

	public void setArticletitle(String articletitle) {
		Articletitle = articletitle;
	}

	

	public void setAltTitle(String altTitle) {
		this.altTitle = altTitle;
	}



	public String getArticletitle() {
		return Articletitle;
	}



	public String getAltTitle() {
		return altTitle;
	}



	@Override
	public String toString() {
		return "TitleGroup [Articletitle=" + Articletitle + ", altTitle=" + altTitle + "]";
	}




}
