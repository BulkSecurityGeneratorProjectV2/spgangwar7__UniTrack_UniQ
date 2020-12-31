package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("kwd-group")
public class kwdGroup {
	
	@XStreamAlias("kwd")
	@XStreamImplicit
	private List<String> kwdgroup;

	

	public List<String> getKwdgroup() {
		return kwdgroup;
	}



	public void setKwdgroup(List<String> kwdgroup) {
		this.kwdgroup = kwdgroup;
	}



	@Override
	public String toString() {
		return "kwdGroup [kwdgroup=" + kwdgroup + "]";
	}


}
